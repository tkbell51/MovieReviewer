package com.tbell.moviereviewer.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String genre;
    private String linkimdb;
    private Date releasedate;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Movie() {}

    public Movie(String title, String genre, String linkimdb, Date releasedate) {
        this.title = title;
        this.genre = genre;
        this.linkimdb = linkimdb;
        this.releasedate = releasedate;
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLinkimdb() {
        return linkimdb;
    }

    public void setLinkimdb(String linkimdb) {
        this.linkimdb = linkimdb;
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }
}
