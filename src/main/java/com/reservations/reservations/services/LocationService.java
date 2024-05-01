package com.reservations.reservations.services;
import com.reservations.reservations.exceptions.GeneralException;
import com.reservations.reservations.models.Location;

import com.reservations.reservations.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public Location save(Location location) throws GeneralException {
        if (location.getSlug() == null || location.getSlug().isBlank())
            throw new GeneralException("Location name is mandatory");
        if (!locationRepository.existsBySlug(location.getSlug()))
            return locationRepository.save(location);
        throw new GeneralException("Locaiton already exist in database");
    }

    public Location findById(Long id) {
        return locationRepository.findById(id).orElse(null);
    }

    public Iterable<Location> findAll() {
        return locationRepository.findAll();
    }

    public Location update(Location location) throws GeneralException {
        if (location.getId() != null) {
            var locationFound = this.locationRepository.findById(location.getId())
                    .orElseThrow(() -> new GeneralException("Location does not exit in the database"));
            var locationFoundBySlug = this.locationRepository
                    .findBySlug(location.getSlug());
            if (locationFoundBySlug != null && locationFoundBySlug.getId() != location.getId()) {
                throw new GeneralException("New Location already exist in database");
            }
            locationFound.setLocality(
                    location.getLocality() != null
                            ? location.getLocality()
                            : locationFound.getLocality());
            locationFound.setAddress(
                    location.getAddress() != null && !location.getAddress().isBlank()
                            ? location.getAddress()
                            : locationFound.getAddress());
            locationFound.setDesignation(
                    location.getDesignation() != null && !location.getDesignation().isBlank()
                            ? location.getDesignation()
                            : locationFound.getDesignation());
            locationFound.setPhone(
                    location.getPhone() != null && !location.getPhone().isBlank()
                            ? location.getPhone()
                            : locationFound.getPhone());
            locationFound.setSlug(
                    location.getSlug() != null && !location.getSlug().isBlank()
                            ? location.getSlug()
                            : locationFound.getSlug());
            locationFound.setWebsite(
                    location.getWebsite() != null && !location.getWebsite().isBlank()
                            ? location.getWebsite()
                            : locationFound.getWebsite());
            return this.locationRepository.save(locationFound);
        }
        throw new GeneralException("Location to update could not be found");
    }

    public void delete(Long id) throws GeneralException {
        if (locationRepository.existsById(id)) {
            locationRepository.deleteById(id);
        } else {
            throw new GeneralException("Location not found with ID: " + id);
        }
    }
}
