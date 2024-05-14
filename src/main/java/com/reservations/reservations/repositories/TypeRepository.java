package com.reservations.reservations.repositories;

import com.reservations.reservations.models.Location;
import com.reservations.reservations.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
    public boolean existsByType(String type);
    public Type findByType(String type);
}
