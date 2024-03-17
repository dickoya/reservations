package com.reservations.reservations.models;

import jakarta.persistence.*;

@Entity
@Table(name="artists")
public class Artist {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    //@NotEmpty(message = "The lastname must not be empty.")

    private String lastname;


    protected Artist() {
    }
    public Artist(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
