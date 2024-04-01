package com.reservations.reservations.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="representations")
public class Representation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;

    private Integer PlaceAvailable;

    /**
     * Date de la représentation
     */
    private LocalDateTime representationDate;

    /**
     * Lieu de prestation de la représentation
     */
    @ManyToOne
    @JoinColumn(name="location_id", nullable=true)
    private Location location;

    @ManyToMany
    @JoinTable(
            name = "representations_users",
            joinColumns = @JoinColumn(name = "representation_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();

    public Representation() { }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getRepresentationDate() {
        return representationDate;
    }

    public void setRepresentationDate(LocalDateTime representationDate) {
        this.representationDate = representationDate;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Integer getPlaceAvailable() {
        return PlaceAvailable;
    }

    public void setPlaceAvailable(Integer numberOfPlaceAvailable) {
        PlaceAvailable = numberOfPlaceAvailable;
    }
}
