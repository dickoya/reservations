package com.reservations.reservations.models;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id; // L'identifiant unique de l'utilisateur
    private String login; // Le nom d'utilisateur de l'utilisateur
    private String password; // Le mot de passe de l'utilisateur
    private String firstname; // Le prénom de l'utilisateur
    private String lastname; // Le nom de famille de l'utilisateur
    private String email; // L'adresse e-mail de l'utilisateur
    private String langue; // La langue préférée de l'utilisateur
    private String role; // Le role de l'utilisateur (soit Admin ou User)

    // Constructeur
    public User(int id, String login, String password, String firstname, String lastname, String email, String langue, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.langue = langue;
        this.role = role;
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

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
