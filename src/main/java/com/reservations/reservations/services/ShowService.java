package com.reservations.reservations.services;


import com.reservations.reservations.models.Show;
import com.reservations.reservations.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public Show save(Show show){return showRepository.save(show);}

    public Show findById(Long id) {
        return showRepository.findById(id).orElse(null);
    }

    public Iterable<Show> findAll() {
        return showRepository.findAll();
    }

    public void delete(Show show) {
        showRepository.delete(show);
    }

    public void deleteById(Long id) {
        showRepository.deleteById(id);
    }
}
