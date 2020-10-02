package pe.upc.bcp.service;

import pe.upc.bcp.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User u);
    List<User> getAllUsers();
    Optional<User> getUserByID(Long id);
}
