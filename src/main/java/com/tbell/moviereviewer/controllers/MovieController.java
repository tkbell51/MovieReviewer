package com.tbell.moviereviewer.controllers;

import com.tbell.moviereviewer.Interfaces.MovieRepository;
import com.tbell.moviereviewer.Interfaces.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {
    @Autowired
    MovieRepository repo;
    @Autowired
    ReviewRepository reviewRepo;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
