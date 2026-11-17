package br.com.cinematch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cinematch.model.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long>{
    Optional<Movie> findByImdbId(String imdbId);
    List<Movie> findByTitleContainingIgnoreCase(String title);
    Boolean existsByImdbId(String imdbId);
}
