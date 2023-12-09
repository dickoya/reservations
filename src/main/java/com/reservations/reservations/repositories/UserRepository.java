package com.reservations.reservations.repositories;

import com.reservations.reservations.models.Artist;
import com.reservations.reservations.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
