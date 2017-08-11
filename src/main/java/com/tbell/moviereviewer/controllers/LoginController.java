package com.tbell.moviereviewer.controllers;

import com.tbell.moviereviewer.Interfaces.RoleRepository;
import com.tbell.moviereviewer.Interfaces.UserRepository;
import com.tbell.moviereviewer.models.Role;
import com.tbell.moviereviewer.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    UserRepository userRepo;
    @Autowired
    RoleRepository roleRepo;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model, HttpServletRequest request) {
        model.addAttribute("user", new User());
        try {
            Object message = request.getSession().getAttribute("error");
            model.addAttribute("error", message);
            request.getSession().removeAttribute("error");
        } catch (Exception ex) {}
        return "login";
    }

    @RequestMapping(value = "/login/createUser", method = RequestMethod.POST)
    public String createUser (@RequestParam("username")String username,
                              @RequestParam("password")String password,
                              @RequestParam("gender")String gender,
                              @RequestParam("age") String age,
                              @RequestParam("occupation")String occupation,
                              Model model){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setGender(gender);
            int userAge = Integer.parseInt(age);
            user.setAge(userAge);
            user.setOccupation(occupation);
            Role role = roleRepo.findByName("ROLE_USER");
            user.setRole(role);
            userRepo.save(user);

            return "redirect:/login";
        }



}
