package com.reservations.reservations.models;

import jakarta.persistence.*;

@Entity
@Table(name="representation_user")
public class Representation_user {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="representation_id", nullable=true)
    private Representation representations;

    private int user_id;

    private int place;


}
