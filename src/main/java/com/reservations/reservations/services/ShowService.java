package com.reservations.reservations.services;

import com.reservations.reservations.models.Representation;
import com.reservations.reservations.models.Show;
import com.reservations.reservations.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;

    public Show findById(Long id) {
        return showRepository.findById(id).orElse(null);
    }

    public Page<Show> findBy(String searchString, int page, int size, String sortBy, String order) {

        Sort.Direction direction = Sort.Direction.ASC;
        if (order.equalsIgnoreCase("desc"))
            direction = Sort.Direction.DESC;
        PageRequest pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));

        String searchQuery = "%"+searchString+"%";
        return showRepository.findAllByTitleLike(searchQuery, pageable);
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public void saveAll(List<Show> shows) {
    }
}
