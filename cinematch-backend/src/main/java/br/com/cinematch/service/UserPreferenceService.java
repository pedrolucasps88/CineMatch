package br.com.cinematch.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.cinematch.model.User;
import br.com.cinematch.model.UserPreference;
import br.com.cinematch.repository.UserPreferenceRepository;
import br.com.cinematch.repository.UserRepository;

@Service
public class UserPreferenceService {

    private final UserPreferenceRepository repository;
    private final UserRepository userRepository;

    public UserPreferenceService(
            UserPreferenceRepository repository,
            UserRepository userRepository) {

        this.repository = repository;
        this.userRepository = userRepository;
    }

    public boolean addPreference(Long userId, String genre, int weight) {

        if (userId == null || genre == null || genre.isBlank() || weight <= 0) {
            return false;
        }

        String normalizedGenre = genre.trim();

        Optional<User> user = userRepository.findById(userId);

        if (!user.isPresent()) {
            System.out.println("User not found");
            return false;
        }

        Optional<UserPreference> preference =
                repository.findByUserIdAndGenre(userId, normalizedGenre);

        if (preference.isPresent()) {
            System.out.println("Genre preference already exists");
            return false;
        }

        UserPreference newPreference = new UserPreference();

        newPreference.setUser(user.get());
        newPreference.setGenre(normalizedGenre);
        newPreference.setPreferenceWeight(weight);

        repository.save(newPreference);

        System.out.println("Preference added");
        return true;
    }

    public List<UserPreference> getUserPreferences(Long userId) {

        if (userId == null) {
            return new ArrayList<>();
        }

        return repository.findByUserId(userId);
    }

    public boolean updatePreferenceWeight(
            Long userId, String genre, int newWeight) {

        if (userId == null || genre == null ||
                genre.isBlank() || newWeight <= 0) {
            return false;
        }

        String normalizedGenre = genre.trim();

        Optional<UserPreference> preference =
                repository.findByUserIdAndGenre(userId, normalizedGenre);

        if (preference.isPresent()) {
            UserPreference existingPreference = preference.get();

            existingPreference.setPreferenceWeight(newWeight);

            repository.save(existingPreference);

            System.out.println("Preference weight updated");
            return true;
        }

        System.out.println("Preference not found");
        return false;
    }

    public boolean deletePreference(Long userId, String genre) {

        if (userId == null || genre == null || genre.isBlank()) {
            return false;
        }

        String normalizedGenre = genre.trim();

        Optional<UserPreference> preference =
                repository.findByUserIdAndGenre(userId, normalizedGenre);

        if (preference.isPresent()) {
            repository.delete(preference.get());

            System.out.println("Preference removed");
            return true;
        }

        System.out.println("Preference not found");
        return false;
    }
}
