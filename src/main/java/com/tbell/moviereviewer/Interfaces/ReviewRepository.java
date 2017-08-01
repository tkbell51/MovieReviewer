package com.tbell.moviereviewer.Interfaces;

import com.tbell.moviereviewer.models.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}
