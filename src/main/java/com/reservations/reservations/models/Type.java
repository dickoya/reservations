package com.reservations.reservations.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="types")
public class Type {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "artist_id")
    private String artist_id;

    @ManyToMany
    @JoinTable(name = "artist_type", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "artist_id"))
    private List<Artist> artists = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(String artist_id) {
        this.artist_id = artist_id;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}
