package com.webapp.prueba.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.prueba.dao.UserDao;
import org.springframework.web.bind.annotation.*;

import com.webapp.prueba.models.User;
import com.webapp.utils.JWTUtil;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value= "api/users", method=RequestMethod.GET)
    public List<User> getUsers(@RequestHeader(value= "Authorization") String token) {
        if(!validarToken(token)){ return null }
        return userDao.getUsers();
    }

    private boolean validarToken(String token){
        String userID = jwtU
    }

    @RequestMapping(value= "api/users", method=RequestMethod.POST)
    public void registeruser(@RequestBody User user) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(hash);
        userDao.registerUser(user);
    }


    
    
}
