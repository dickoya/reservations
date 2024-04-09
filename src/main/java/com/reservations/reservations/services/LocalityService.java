package com.reservations.reservations.services;

import com.reservations.reservations.GeneralException.GeneralException;
import com.reservations.reservations.models.Locality;
import com.reservations.reservations.repositories.LocalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalityService {

    @Autowired
    private LocalityRepository localityRepository;

    public Locality save(Locality locality) throws GeneralException {
        if (locality.getLocality() == null || locality.getLocality().isBlank())
            throw new GeneralException("Locality name is mandatory");
        if (!localityRepository.existsByLocality(locality.getLocality()))
            return localityRepository.save(locality);
        throw new GeneralException("Locality already exist in database");
    }

    public Locality findById(Long id) {
        return localityRepository.findById(id).orElse(null);
    }

    public Iterable<Locality> findAll() {
        return localityRepository.findAll();
    }

    public Locality update(Locality locality) throws GeneralException {
        if (locality.getId() != null) {
            var localityFound = this.localityRepository.findById(locality.getId())
                    .orElseThrow(() -> new GeneralException("Locality does not exit in the database"));
            var blogCategoryFoundByName = this.localityRepository
                    .findByLocality(locality.getLocality());
            if (blogCategoryFoundByName != null && blogCategoryFoundByName.getId() != localityFound.getId()) {
                throw new GeneralException("New locality name already exist in database");
            }
            localityFound.setLocality(
                    locality.getLocality() != null && !locality.getLocality().isBlank()
                            ? locality.getLocality()
                            : localityFound.getLocality());
            localityFound.setPostalCode(
                    locality.getPostalCode() != null && !locality.getPostalCode().isBlank()
                            ? locality.getPostalCode()
                            : localityFound.getPostalCode());
            return this.localityRepository.save(localityFound);
        }
        throw new GeneralException("Locality to update could not be found");
    }

    public void delete(Long id) throws GeneralException {
        if (localityRepository.existsById(id)) {
            localityRepository.deleteById(id);
        } else {
            throw new GeneralException("Locality not found with ID: " + id);
        }
    }
}