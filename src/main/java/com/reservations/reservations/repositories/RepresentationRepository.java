package com.reservations.reservations.repositories;

import com.reservations.reservations.models.Representation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepresentationRepository extends JpaRepository<Representation, Long> {
    //List<Representation> findByShowTitleContainingIgnoreCase(String title);

    List<Representation> findAllByOrderByShowTitleAsc();
    List<Representation> findAllByOrderByShowTitleDesc();
    List<Representation> findAllByOrderByRepresentationDateAsc();
    List<Representation> findAllByOrderByRepresentationDateDesc();
    Page<Representation> findAllByShowTitleLike(String searchString, PageRequest pageable);


}
