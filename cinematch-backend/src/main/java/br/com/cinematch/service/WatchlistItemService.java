package br.com.cinematch.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.cinematch.model.Movie;
import br.com.cinematch.model.User;
import br.com.cinematch.model.WatchlistItem;
import br.com.cinematch.repository.MovieRepository;
import br.com.cinematch.repository.UserRepository;
import br.com.cinematch.repository.WatchlistItemRepository;

@Service 
public class WatchlistItemService {
    private final WatchlistItemRepository repository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    public WatchlistItemService(
            WatchlistItemRepository repository,
            UserRepository userRepository,
            MovieRepository movieRepository) {

        this.repository = repository;
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
    }

    public boolean addToWatchlist(Long userId, Long movieId) {

        if (userId == null || movieId == null) {
            return false;
        }

        if (repository.existsByUserIdAndMovieId(userId, movieId)) {
            System.out.println("Movie already in watchlist");
            return false;
        }

        Optional<User> user = userRepository.findById(userId);
        Optional<Movie> movie = movieRepository.findById(movieId);

        if (!user.isPresent() || !movie.isPresent()) {
            System.out.println("User or movie not found");
            return false;
        }

        WatchlistItem item = new WatchlistItem();

        item.setUser(user.get());
        item.setMovie(movie.get());
        item.setAddedAt(LocalDateTime.now());
        item.setWatched(false);

        repository.save(item);

        System.out.println("Movie added to watchlist");
        return true;
    }

    public List<WatchlistItem> getUserWatchlist(Long userId) {

        if (userId == null) {
            return new ArrayList<>();
        }

        return repository.findByUserId(userId);
    }

    public boolean markAsWatched(Long userId, Long movieId) {

        if (userId == null || movieId == null) {
            return false;
        }

        Optional<WatchlistItem> item =
                repository.findByUserIdAndMovieId(userId, movieId);

        if (item.isPresent()) {
            WatchlistItem watchlistItem = item.get();

            watchlistItem.setWatched(true);

            repository.save(watchlistItem);

            return true;
        }

        System.out.println("Watchlist item not found");
        return false;
    }

    public boolean removeFromWatchlist(Long userId, Long movieId) {

        if (userId == null || movieId == null) {
            return false;
        }

        Optional<WatchlistItem> item =
                repository.findByUserIdAndMovieId(userId, movieId);

        if (item.isPresent()) {
            repository.delete(item.get());

            System.out.println("Movie removed from watchlist");
            return true;
        }

        System.out.println("Watchlist item not found");
        return false;
    }
}
