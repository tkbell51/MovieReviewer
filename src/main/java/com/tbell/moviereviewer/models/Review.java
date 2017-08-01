package com.tbell.moviereviewer.models;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String reviewername;
    private int reviewerage;
    private String reviewergender;
    private String revieweroccupation;
    private double movierating;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Review() {
    }

    public Review(String reviewername, int reviewerage, String reviewergender, String revieweroccupation, double movierating, Movie movie) {
        this.reviewername = reviewername;
        this.reviewerage = reviewerage;
        this.reviewergender = reviewergender;
        this.revieweroccupation = revieweroccupation;
        this.movierating = movierating;
        this.movie = movie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReviewername() {
        return reviewername;
    }

    public void setReviewername(String reviewername) {
        this.reviewername = reviewername;
    }

    public int getReviewerage() {
        return reviewerage;
    }

    public void setReviewerage(int reviewerage) {
        this.reviewerage = reviewerage;
    }

    public String getReviewergender() {
        return reviewergender;
    }

    public void setReviewergender(String reviewergender) {
        this.reviewergender = reviewergender;
    }

    public String getRevieweroccupation() {
        return revieweroccupation;
    }

    public void setRevieweroccupation(String revieweroccupation) {
        this.revieweroccupation = revieweroccupation;
    }

    public double getMovierating() {
        return movierating;
    }

    public void setMovierating(double movierating) {
        this.movierating = movierating;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
