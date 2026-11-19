package br.com.cinematch.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.cinematch.model.Movie;
import br.com.cinematch.repository.MovieRepository;

@Service
public class MovieService {
     private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Movie getMovieById(Long id) {
        if (id == null) {
            return null;
        }

        Optional<Movie> movie = repository.findById(id);

        if (movie.isPresent()) {
            return movie.get();
        } else {
            System.out.println("Movie ID not found");
            return null;
        }
    }

    public Movie getMovieByImdbId(String imdbId) {
        if (imdbId == null || imdbId.isBlank()) {
            return null;
        }

        Optional<Movie> movie = repository.findByImdbId(imdbId.trim());

        if (movie.isPresent()) {
            return movie.get();
        } else {
            System.out.println("IMDb ID not found");
            return null;
        }
    }

    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    public List<Movie> searchMoviesByTitle(String title) {
        if (title == null || title.isBlank()) {
            return new ArrayList<>();
        }

        return repository.findByTitleContainingIgnoreCase(title.trim());
    }

    public Movie saveMovie(Movie movie) {
        if (movie == null) {
            return null;
        }

        return repository.save(movie);
    }

    public boolean deleteMovie(Long id) {
        if (id == null || !repository.existsById(id)) {
            System.out.println("Movie ID not found");
            return false;
        }

        repository.deleteById(id);
        System.out.println("Movie deleted");
        return true;
    }

}
