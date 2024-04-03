package com.reservations.reservations.repositories;

import com.reservations.reservations.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {

    public boolean existsByAddress(String address);

    public Location findByAddress(String address);

}
