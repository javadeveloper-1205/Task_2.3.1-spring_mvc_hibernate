package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    User read(int userId);

    void update(User user);

    void delete(int userId);

    List<User> getAllUsers();
}
