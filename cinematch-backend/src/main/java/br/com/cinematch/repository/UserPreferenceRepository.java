package br.com.cinematch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cinematch.model.UserPreference;

public interface UserPreferenceRepository extends JpaRepository<UserPreference,Long>{
    List<UserPreference> findByUserId(Long userId);
    Optional<UserPreference> findByUserIdAndGenre(Long userId,String genre);

}
