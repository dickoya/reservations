package com.reservations.reservations.repositories;

import com.reservations.reservations.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {
}
