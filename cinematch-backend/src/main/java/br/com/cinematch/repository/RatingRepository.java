package br.com.cinematch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cinematch.model.Rating;

public interface RatingRepository extends JpaRepository<Rating,Long>{
    List<Rating> findByUserId(Long userId);
    Optional<Rating> findByUserIdAndMovieId(Long userId, Long movieId);
    Boolean existsByUserIdAndMovieId(Long userId, Long movieId);
}
