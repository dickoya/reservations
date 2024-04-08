package com.reservations.reservations.repositories;

import com.reservations.reservations.models.Representation;
import com.reservations.reservations.models.Show;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {
    Page<Show> findAllByTitleLike(String searchString, PageRequest pageable);
}
