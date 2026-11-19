package br.com.cinematch.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.cinematch.model.Movie;
import br.com.cinematch.model.Rating;
import br.com.cinematch.model.RatingType;
import br.com.cinematch.model.User;
import br.com.cinematch.repository.MovieRepository;
import br.com.cinematch.repository.RatingRepository;
import br.com.cinematch.repository.UserRepository;

public class RatingService {
    private final RatingRepository repository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    public RatingService(
            RatingRepository repository,
            UserRepository userRepository,
            MovieRepository movieRepository) {

        this.repository = repository;
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
    }

    public boolean rateMovie(Long userId, Long movieId, RatingType type) {

        if (userId == null || movieId == null || type == null) {
            return false;
        }

        Optional<User> user = userRepository.findById(userId);
        Optional<Movie> movie = movieRepository.findById(movieId);

        if (!user.isPresent() || !movie.isPresent()) {
            System.out.println("User or movie not found");
            return false;
        }

        Optional<Rating> rating =
                repository.findByUserIdAndMovieId(userId, movieId);

        if (rating.isPresent()) {
            Rating existingRating = rating.get();
            existingRating.setType(type);
            existingRating.setCreatedAt(LocalDateTime.now());
            repository.save(existingRating);
        } else {
            Rating newRating = new Rating(
                    user.get(),
                    movie.get(),
                    type
            );

            repository.save(newRating);
        }

        return true;
    }

    public List<Rating> getUserRatings(Long userId) {
        if (userId == null) {
            return new ArrayList<>();
        }

        return repository.findByUserId(userId);
    }

    public List<Rating> getMovieRatings(Long movieId) {
        if (movieId == null) {
            return new ArrayList<>();
        }

        return repository.findByMovieId(movieId);
    }

    public Rating getUserRatingForMovie(Long userId, Long movieId) {
        if (userId == null || movieId == null) {
            return null;
        }

        Optional<Rating> rating =
                repository.findByUserIdAndMovieId(userId, movieId);

        if (rating.isPresent()) {
            return rating.get();
        }

        return null;
    }

    public boolean deleteRating(Long userId, Long movieId) {
        if (userId == null || movieId == null) {
            return false;
        }

        Optional<Rating> rating =
                repository.findByUserIdAndMovieId(userId, movieId);

        if (rating.isPresent()) {
            repository.delete(rating.get());
            return true;
        }

        return false;
    }
    
}
