package com.reservations.reservations.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="localities")
public class Locality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The postal Code must not be empty.")
    @Size(max = 6, message = "The postal Code must be 6 characters long.")
    private String postalCode;

    @NotEmpty(message = "The locality must not be empty.")
    @Size(max = 60, message = "The locality must be 60 characters long.")
    private String locality;


    @OneToMany(targetEntity = Location.class, mappedBy = "locality")
    private List<Location> locations = new ArrayList<>();

    public Locality() {
    }

    public Locality(String postalCode, String locality) {
        this.postalCode = postalCode;
        this.locality = locality;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}