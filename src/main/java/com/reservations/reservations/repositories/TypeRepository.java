package com.reservations.reservations.repositories;
import com.reservations.reservations.models.Types;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Types, Long> {
}
