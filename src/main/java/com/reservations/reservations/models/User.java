package com.reservations.reservations.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id; // L'identifiant unique de l'utilisateur
    @Column(name = "login", nullable = false)
    private String login; // Le nom d'utilisateur de l'utilisateur
    @Column(name = "password", nullable = false)
    private String password; // Le mot de passe de l'utilisateur
    @Column(name = "firstname", nullable = false)
    private String firstname; // Le prénom de l'utilisateur
    @Column(name = "lastname", nullable = false)
    private String lastname; // Le nom de famille de l'utilisateur
    @Column(name = "email", nullable = false)
    private String email; // L'adresse e-mail de l'utilisateur
    @Column(name = "language", nullable = false)
    private String language; // La langue préférée de l'utilisateur
    @Column(name = "role", nullable = false)
    private String role; // Le role de l'utilisateur (soit Admin ou User)
    @CreationTimestamp
    private Date created_at;


    // Constructeur
    public User(int id, String login, String password, String firstname, String lastname, String email, String language, String role, Date created_at) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.language = language;
        this.role = role;
        this.created_at = created_at;
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
