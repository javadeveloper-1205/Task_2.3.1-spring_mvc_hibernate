package web.service;

import web.model.User;

import javax.persistence.FlushModeType;
import java.util.List;

public interface UserService {

    void add(User user);

    void edit(User user);

    User find(int id);

    void delete(int id);

    List<User> getAllUsers();
}