package com.tbell.moviereviewer.services;

import com.tbell.moviereviewer.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);

}
