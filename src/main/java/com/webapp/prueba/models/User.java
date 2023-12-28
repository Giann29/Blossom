package com.webapp.prueba.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "users")
@ToString @EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id")
    private Long id;

    @Getter @Setter @Column(name="username")
    private String username;

    @Getter @Setter @Column(name="email")
    private String email;

    @Getter @Setter @Column(name="phoneNumber")
    private String phoneNumber;

    @Getter @Setter @Column(name="password")
    private String password;


}
