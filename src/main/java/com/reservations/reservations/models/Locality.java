package com.reservations.reservations.models;

import com.reservations.reservations.DTO.LocalityDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "localities")
public class Locality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String postalCode;
    private String locality;
    @OneToMany(targetEntity = Location.class, mappedBy = "locality")
    private List<Location> locations = new ArrayList<>();

    public Locality(Long id, String postalCode, String locality) {
        this.id = id;
        this.postalCode = postalCode;
        this.locality = locality;
    }

    public Locality(String locality, String postalCode) {
        this.postalCode = postalCode;
        this.locality = locality;
    }

    public Locality() {
    }

    public Locality(LocalityDTO localityDTO) {
        this.id = localityDTO.getId();
        this.locality = localityDTO.getLocality();
        this.postalCode = localityDTO.getPostalCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public static LocalityDTO fromLocality(Locality locality) {
        return new LocalityDTO(locality);
    }

    public static Locality toLocality(LocalityDTO localityDTO) {
        return new Locality(localityDTO);
    }
}
