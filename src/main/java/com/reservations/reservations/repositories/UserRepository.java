package com.reservations.reservations.repositories;

import com.reservations.reservations.models.Artist;
import com.reservations.reservations.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByLogin(String login);
    List<User> findByLastname(String lastname);

    User findUsersById(long id);

}
