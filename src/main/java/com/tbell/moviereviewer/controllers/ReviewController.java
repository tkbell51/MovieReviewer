package com.tbell.moviereviewer.controllers;

import com.tbell.moviereviewer.Interfaces.MovieRepository;
import com.tbell.moviereviewer.Interfaces.ReviewRepository;
import com.tbell.moviereviewer.Interfaces.UserRepository;
import com.tbell.moviereviewer.models.Movie;
import com.tbell.moviereviewer.models.Review;
import com.tbell.moviereviewer.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class ReviewController {
    @Autowired
    MovieRepository repo;
    @Autowired
    ReviewRepository reviewRepo;
    @Autowired
    UserRepository userRepo;

    @RequestMapping(value = "/movie/{movieId}/createReview/", method = RequestMethod.POST)
    public String createReview(@PathVariable("movieId") long movieId,
                               @RequestParam("message") String message,
                               @RequestParam("movierating")Double movierating,
                               Principal principal) {
        Movie movie = repo.findOne(movieId);
        String username = principal.getName();
        User user = userRepo.findByUsername(username);
        Review newReview = new Review(movierating, message, movie, user);
        reviewRepo.save(newReview);
        return "redirect:/movie/" + movieId +'/';
    }
}
