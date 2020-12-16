package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    User find(int id);

    void delete(int id);

    List<User> getAllUsers();
}














//    void update(int id, User user);