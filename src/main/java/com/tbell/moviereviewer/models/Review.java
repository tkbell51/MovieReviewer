package com.tbell.moviereviewer.models;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double movierating;
    private String message;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_data_id")
    private User user;

    public Review() {
    }

    public Review(double movierating, String message, Movie movie, User user) {

        this.movierating = movierating;
        this.message = message;
        this.movie = movie;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMovierating() {
        return movierating;
    }

    public void setMovierating(double movierating) {
        this.movierating = movierating;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
