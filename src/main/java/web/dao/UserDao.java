package web.dao;

import web.model.User;

import javax.persistence.FlushModeType;
import java.util.List;

public interface UserDao {

    void addUser(User user);

    List<User> getAllUsers();

    void save(User user);

    User getUserFromLogin(String name);

    User findUser(int id);

    void deleteUser(int id);
}


//    void updateUser (int id, User user);