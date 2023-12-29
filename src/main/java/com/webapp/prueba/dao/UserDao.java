package com.webapp.prueba.dao;

import java.util.List;
import com.webapp.prueba.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UserDao implements IUserDao{
    @PersistenceContext
    private EntityManager em;
    @Override
    @Transactional
    public List<User> getUsers() {
        String query = "FROM Users";
        return em.createQuery(query).getResultList();
    }
    @Override
    public User getUser(User user) {
        String query = "FROM Users WHERE email = :email";
        List<User> users = em.createQuery(query)
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
        em.merge(user);
    }
    
}
