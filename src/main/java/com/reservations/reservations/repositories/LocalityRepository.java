package com.reservations.reservations.repositories;

import com.reservations.reservations.models.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocalityRepository extends JpaRepository<Locality, Long> {

}
