package com.webapp.Blossom.dao;

import java.util.List;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.Blossom.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UserDao implements IUserDao{

    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    @Transactional
    public List<User> getUsers() {
        String query = "FROM Users";
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public User getUser(User user) {
        String query = "FROM Users WHERE email = :email";
        List<User> users = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .getResultList();
        if(users.isEmpty()){
            return null;
        }
        String hashedPassword = users.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(hashedPassword, user.getPassword())){
            return users.get(0);
        }
        return null;
    }
    @Override
    public void registerUser(User user) {
        entityManager.merge(user);
    }
    
}
