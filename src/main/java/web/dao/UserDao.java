package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void addUser (User user);

    List<User> getAllUsers();

    User findUser(int id);

    void deleteUser (int id);
}














//    void updateUser (int id, User user);