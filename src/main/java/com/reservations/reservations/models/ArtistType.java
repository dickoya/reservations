package com.reservations.reservations.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artist_type")
public class ArtistType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany
    @JoinTable(
        name = "artist_type", 
        joinColumns = @JoinColumn(name = "type_id"), inverseJoinColumns = @JoinColumn(name = "artist_id"))
    private List<Artist> artists = new ArrayList<>();
    @ManyToOne
    @JoinColumn(
        name = "type_id",
        nullable = false
    )
    private Type type;

    @ManyToMany(targetEntity = Show.class)
    @JoinTable(
        name = "artist_type_show", 
        joinColumns = @JoinColumn(name = "artist_type_id"), inverseJoinColumns = @JoinColumn(name = "show_id")
    )
    private List<Show> shows = new ArrayList<>();

    public ArtistType(List<Artist> artists, Type type, List<Show> shows) {
        this.artists = artists;
        this.type = type;
        this.shows = shows;
    }

    public ArtistType() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    @Override
    public String toString() {
        return "ArtistType{" +
                "id=" + id +
                ", artists=" + artists +
                ", type=" + type +
                ", shows=" + shows +
                '}';
    }
}
