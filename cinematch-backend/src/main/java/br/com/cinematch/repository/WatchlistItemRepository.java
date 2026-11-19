package br.com.cinematch.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cinematch.model.WatchlistItem;

public interface WatchlistItemRepository extends JpaRepository<WatchlistItem,Long>{
    List<WatchlistItem> findByUserId(Long userId);
    Boolean existsByUserIdAndMovieId(Long userId,Long movieId);
}
