package com.webapp.Blossom.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.Blossom.dao.UserDao;
import com.webapp.Blossom.models.User;
import com.webapp.Blossom.utils.JWTUtil;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class AuthController {
    @Autowired
    private UserDao userDao;
 
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method=RequestMethod.POST)
      public String login(@RequestBody User user) {
        User loggedUser = userDao.getUser(user);
        if (loggedUser != null){
            String token = jwtUtil.create(String.valueOf(loggedUser.getId()), loggedUser.getUsername());
            return token;
        }
        return "FAIL";
    }
    
}
