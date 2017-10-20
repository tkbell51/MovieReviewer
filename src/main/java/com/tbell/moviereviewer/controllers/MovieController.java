package com.tbell.moviereviewer.controllers;

import com.tbell.moviereviewer.Interfaces.MovieRepository;
import com.tbell.moviereviewer.Interfaces.ReviewRepository;
import com.tbell.moviereviewer.Interfaces.UserRepository;
import com.tbell.moviereviewer.models.Movie;
import com.tbell.moviereviewer.models.Review;
import com.tbell.moviereviewer.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class MovieController {
    @Autowired
    MovieRepository repo;
    @Autowired
    ReviewRepository reviewRepo;
    @Autowired
    UserRepository userRepo;

    @RequestMapping("/")
    public String index(Model model){
        Iterable<Movie> movies = repo.findAll();
        model.addAttribute("movie", movies);


        return "index";
    }

    @RequestMapping("/movie/")
    public String indexSignedIn(Model model, Principal principal){
        String username = principal.getName();
        User user = userRepo.findByUsername(username);
        model.addAttribute("user", user);

        Iterable<Movie> movies = repo.findAll();
        model.addAttribute("movie", movies);
        return "index";
    }

    @RequestMapping(value = "/movie/{movieId}/", method = RequestMethod.GET)
    public String movieDetail(@PathVariable("movieId")long movieId,
                               Model model, Principal principal){
        String username = principal.getName();
        User user = userRepo.findByUsername(username);
        model.addAttribute("user", user);


        Movie movie = repo.findOne(movieId);
        Iterable<Review> reviews = reviewRepo.findAllByMovie(movie);
        model.addAttribute("review", reviews);
        model.addAttribute("movie", movie);
        return "movieDetail";
    }
    @RequestMapping(value = "/movie/createMovie/", method = RequestMethod.POST)
    public String createMovie(@RequestParam("title")String title,
                              @RequestParam("genre")String genre,
                              @RequestParam("linkimdb")String linkimdb,
                              @RequestParam("releasedate")String releasedate,
                              @RequestParam("imgurl")String imgurl){
        genre = genre.replaceAll("[,.!?;:]", "$0 ").replaceAll("\\s+", " ");
        Movie movie = new Movie( title, genre, imgurl, linkimdb, releasedate);
    repo.save(movie);
    return "redirect:/movie/";
    }


    @RequestMapping(value = "/movie/edit/{movieId}/editMovie/", method = RequestMethod.POST)
    public String editMovie(@PathVariable("movieId") long movieId,
                            @RequestParam("title") String title,
                            @RequestParam("genre") String genre,
                            @RequestParam("linkimdb") String linkimdb,
                            @RequestParam("releasedate") String releasedate,
                            @RequestParam("imgurl")String imgurl){

        Movie movie = repo.findOne(movieId);
        movie.setTitle(title);
        movie.setGenre(genre);
        movie.setLinkimdb(linkimdb);
        movie.setReleasedate(releasedate);
        movie.setImgurl(imgurl);
        repo.save(movie);

        return "redirect:/movie/" + movieId + "/";
    }
}
