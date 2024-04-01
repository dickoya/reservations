package com.reservations.reservations.repositories;

import com.reservations.reservations.models.RepresentationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepresentationUserRepository extends JpaRepository<RepresentationUser, Long> {
}
