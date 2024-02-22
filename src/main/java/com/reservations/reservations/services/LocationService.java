package com.reservations.reservations.services;

import com.reservations.reservations.models.Location;
import com.reservations.reservations.models.Types;
import com.reservations.reservations.repositories.LocationRepository;
import com.reservations.reservations.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService{
    @Autowired
    private LocationRepository locationRepository;
    public Iterable<Location> findAll() {
        return locationRepository.findAll();
    }

}
