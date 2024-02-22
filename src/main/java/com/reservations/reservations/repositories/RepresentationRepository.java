package com.reservations.reservations.repositories;

import com.reservations.reservations.models.Representation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepresentationRepository extends JpaRepository<Representation, Long> {
}
