package pe.upc.bcp.service;

import pe.upc.bcp.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User u);
    List<User> getAllUsers();
}
