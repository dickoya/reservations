package com.reservations.reservations.models;

import com.reservations.reservations.DTO.LocationsDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "slug")
    private String slug;
    @Column(name = "designation")
    private String designation;
    @Column(name = "address")
    private String address;
    @ManyToOne
    @JoinColumn(name = "locality_id", nullable = false)
    private Locality locality;
    @Column(name = "website")
    private String website;
    @Column(name = "phone")
    private String phone;

    @OneToMany(targetEntity = Show.class, mappedBy = "location")
    private List<Show> shows = new ArrayList<>();

    @OneToMany(targetEntity = Representation.class, mappedBy = "location")
    private List<Representation> representations = new ArrayList<>();

    public Location() {
    }

    public Location(LocationsDTO locationsDTO) {
        this.id = locationsDTO.getId();
        this.designation = locationsDTO.getDesignation();
        this.slug = locationsDTO.getSlug();
        this.address = locationsDTO.getAddress();
        this.locality = locationsDTO.getLocality();
        this.phone = locationsDTO.getPhone();
        this.website = locationsDTO.getWebsite();
    }

    public static LocationsDTO fromLocation(Location location) {
        return new LocationsDTO(location);
    }

    public static Location toLocation(LocationsDTO locationsDTO) {
        return new Location(locationsDTO);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public List<Representation> getRepresentations() {
        return representations;
    }

    public void setRepresentations(List<Representation> representations) {
        this.representations = representations;
    }

}
