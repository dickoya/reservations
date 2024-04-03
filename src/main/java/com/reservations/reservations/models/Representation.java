package com.reservations.reservations.models;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="representations")
public class Representation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * Date de création de la représentation
     */
    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;

    private Time when;

    /**
     * Lieu de prestation de la représentation
     */
    @ManyToOne
    @JoinColumn(name="location_id", nullable=true)
    private Location location;

    @ManyToMany
    @JoinTable(
            name = "representation_user",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getWhen() {
        return when;
    }

    public void setWhen(Time when) {
        this.when = when;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
