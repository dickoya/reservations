package com.reservations.reservations.repositories;

import com.reservations.reservations.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
    public boolean existsBySlug(String slug);
    public Location findBySlug(String slug);
}

