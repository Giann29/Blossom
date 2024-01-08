package com.webapp.Blossom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.Blossom.dao.UserDao;
import com.webapp.Blossom.models.User;
import com.webapp.Blossom.utils.JWTUtil;

import org.springframework.web.bind.annotation.*;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value= "api/users", method=RequestMethod.GET)
    public List<User> getUsers(@RequestHeader(value= "Authorization") String token) {
        if(!validarToken(token)){ return null; }
        return userDao.getUsers();
    }

    private boolean validarToken(String token){
        String userID = jwtUtil.getKey(token);
        return userID != null;
    }

    @RequestMapping(value= "api/register", method= RequestMethod.POST)
    public void registerUser(@RequestBody User user) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(hash);
        userDao.registerUser(user);
    }


    
    
}
