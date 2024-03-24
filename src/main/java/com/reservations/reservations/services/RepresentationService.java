package com.reservations.reservations.services;

import com.reservations.reservations.models.Representation;
import com.reservations.reservations.repositories.RepresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Service
public class RepresentationService {
    @Autowired
    private RepresentationRepository representationRepository;
    //pagination + filtres + tris en java springboot


    public Representation save(Representation representation) {
        return representationRepository.save(representation);
    }

    public Representation findById(Long id) {
        return representationRepository.findById(id).orElse(null);
    }

    public List<Representation> findAll() {
        return representationRepository.findAll();
    }

    public void delete(Representation representation) {
        representationRepository.delete(representation);
    }

    public void deleteById(Long id) {
        representationRepository.deleteById(id);
    }

//    public List<Representation> findRepresentationsByTitle(String title) {
//        return representationRepository.findByShowTitleContainingIgnoreCase(title);
//    }

    public Page<Representation> findBy(String searchString, int page, int size, String sortBy, String order) {

        Sort.Direction direction = Sort.Direction.ASC;
        if (order.equalsIgnoreCase("desc"))
            direction = Sort.Direction.DESC;
        PageRequest pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));

        String searchQuery = "%"+searchString+"%";
        return representationRepository.findAllByShowTitleLike(searchQuery, pageable);
    }
}
