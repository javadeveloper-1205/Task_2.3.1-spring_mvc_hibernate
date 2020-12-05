package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public void add(User user);

    public void update(User user);

    public void delete(int userId);

    public User getUser(int userId);

    public List getAllUsers();
}
