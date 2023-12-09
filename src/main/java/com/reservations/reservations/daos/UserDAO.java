package com.reservations.reservations.daos;
import com.reservations.reservations.models.User;
import com.reservations.reservations.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAO {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
