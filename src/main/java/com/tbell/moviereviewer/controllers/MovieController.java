package com.tbell.moviereviewer.controllers;

import com.tbell.moviereviewer.Interfaces.MovieRepository;
import com.tbell.moviereviewer.Interfaces.ReviewRepository;
import com.tbell.moviereviewer.models.Movie;
import com.tbell.moviereviewer.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {
    @Autowired
    MovieRepository repo;
    @Autowired
    ReviewRepository reviewRepo;

    @RequestMapping("/movie")
    public String index(Model model){
        Iterable<Movie> movies = repo.findAll();
        model.addAttribute("movie", movies);
        return "index";
    }
    @RequestMapping(value = "/movie/{movieId}", method = RequestMethod.GET)
    public String movieDetail(@PathVariable("movieId")long movieId, Model model){
        Movie movie = repo.findOne(movieId);
        model.addAttribute("movie", movie);
        return "movieDetail";
    }
    @RequestMapping(value = "/createMovie", method = RequestMethod.POST)
    public String createMovie(@RequestParam("title")String title,
                              @RequestParam("genre")String genre,
                              @RequestParam("linkimdb")String linkimdb,
                              @RequestParam("releasedate")String releasedate,
                              @RequestParam("imgurl")String imgurl){
    Movie movie = new Movie( title, genre, imgurl, linkimdb, releasedate);
    repo.save(movie);
    return "redirect:/movie";
    }

    @RequestMapping(value = "/movie/{movieId}/createReview", method = RequestMethod.POST)
    public String createReview(@PathVariable("movieId") long movieId,

                                @RequestParam("reviewername") String reviewername,
                                @RequestParam("message") String message,
                               @RequestParam("reviewergender")String reviewergender,
                               @RequestParam("reviewerage")int reviewerage,
                               @RequestParam("revieweroccupation")String revieweroccupation,
                               @RequestParam("movierating")Double movierating) {
        Movie movie = repo.findOne(movieId);
        Review newReview = new Review(reviewername, reviewerage, reviewergender, revieweroccupation, movierating, message, movie);
        reviewRepo.save(newReview);
        return "redirect:/movie/" + movieId;
    }
//    @RequestMapping("/movie/edit/{movieId}")
//    public String editMovieView(@PathVariable("movieId") long movieId, Model model){
//        Movie movie = repo.findOne(movieId);
//        model.addAttribute("movie", movie);
//        return "";
//
//    }

    @RequestMapping(value = "/movie/edit/{movieId}/editMovie", method = RequestMethod.POST)
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

        return "redirect:/movie/" + movieId;
    }
}
