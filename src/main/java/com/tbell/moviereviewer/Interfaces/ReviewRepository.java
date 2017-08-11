package com.tbell.moviereviewer.Interfaces;

import com.tbell.moviereviewer.models.Movie;
import com.tbell.moviereviewer.models.Review;
import com.tbell.moviereviewer.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findAllByMovie(Movie movie);

    Iterable<Review> findAllByUser(User user);
}
