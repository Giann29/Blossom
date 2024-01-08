package com.webapp.Blossom.dao;

import java.util.List;

import com.webapp.Blossom.models.User;

public interface IUserDao {
    public List<User> getUsers();

    public User getUser(User user);

    public void registerUser(User user);
}
