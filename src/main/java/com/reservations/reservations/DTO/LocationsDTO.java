package com.reservations.reservations.DTO;

import com.reservations.reservations.models.Locality;
import com.reservations.reservations.models.Location;

public class LocationsDTO {
    private Long id;
    private String slug;
    private String designation;
    private String address;
    private Locality locality;
    private String website;
    private String phone;

    public LocationsDTO(Long id, String slug, String designation, String address, Locality locality, String website,
            String phone) {
        this.id = id;
        this.slug = slug;
        this.designation = designation;
        this.address = address;
        this.locality = locality;
        this.website = website;
        this.phone = phone;
    }

    public LocationsDTO() {
    }

    public LocationsDTO(Location location) {
        this.id = location.getId();
        this.slug = location.getSlug();
        this.designation = location.getDesignation();
        this.address = location.getAddress();
        this.locality = location.getLocality();
        this.website = location.getWebsite();
        this.phone = location.getPhone();
    }

    public Long getId() {
        return id;
    }

    public String getSlug() {
        return slug;
    }

    public String getDesignation() {
        return designation;
    }

    public String getAddress() {
        return address;
    }

    public Locality getLocality() {
        return locality;
    }

    public String getWebsite() {
        return website;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
