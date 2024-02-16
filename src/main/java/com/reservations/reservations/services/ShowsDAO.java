package com.reservations.reservations.services;


import com.reservations.reservations.models.Show;
import com.reservations.reservations.repositories.ShowRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ShowsDAO {
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
