package com.tbell.moviereviewer.Interfaces;

import com.tbell.moviereviewer.models.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
}
