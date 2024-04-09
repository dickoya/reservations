package com.reservations.reservations.repositories;
import com.reservations.reservations.models.Locality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalityRepository extends JpaRepository<Locality, Long> {
    public boolean existsByLocality(String locality);

    public Locality findByLocality(String locality);
}

