package com.reservations.reservations.services;

import com.reservations.reservations.models.Representation;
import com.reservations.reservations.models.RepresentationUser;
import com.reservations.reservations.models.User;
import com.reservations.reservations.repositories.RepresentationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepresentationUserService {
    @Autowired
    private RepresentationUserRepository representationUserRepository;

    public List<RepresentationUser> findByUser(User user) {
        return representationUserRepository.findAll();
    }
}
