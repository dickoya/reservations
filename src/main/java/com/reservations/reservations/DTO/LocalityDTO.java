package com.reservations.reservations.DTO;

import com.reservations.reservations.models.Locality;

public class LocalityDTO {
    private Long id;
    private String postalCode;
    private String locality;

    public LocalityDTO(String postalCode, String locality) {
        this.postalCode = postalCode;
        this.locality = locality;
    }

    public LocalityDTO() {
    }

    public LocalityDTO(Locality locality) {
        this.id = locality.getId();
        this.locality = locality.getLocality();
        this.postalCode = locality.getPostalCode();
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getLocality() {
        return locality;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
