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

import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    MovieRepository repo;
    @Autowired
    ReviewRepository reviewRepo;
    @Autowired
    UserRepository userRepo;

    @RequestMapping("/movie/{username}/reviews")
    public String userDetails(@PathVariable("username")String username,
            Model model, Principal principal){

        User user = userRepo.findByUsername(username);
        Iterable<Review> reviews = reviewRepo.findAllByUser(user);
        model.addAttribute("review", reviews);
        model.addAttribute("user",user);
        Iterable<Movie> movies = repo.findAll();
        model.addAttribute("movie", movies);
        return "userDetails";
    }


}
