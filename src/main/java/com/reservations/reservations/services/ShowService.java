package com.reservations.reservations.services;

import com.reservations.reservations.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;
}
