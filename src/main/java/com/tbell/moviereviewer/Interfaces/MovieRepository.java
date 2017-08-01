package com.tbell.moviereviewer.Interfaces;

import com.tbell.moviereviewer.models.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
