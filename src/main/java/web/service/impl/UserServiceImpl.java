package web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;
import web.service.UserService;

import javax.persistence.FlushModeType;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void add(User user) {
        userDao.addUser(user);
    }

    @Override
    public User find(int id) {
       return userDao.findUser(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public void edit(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}


























//    @Override
//    @Transactional
//    public void update(int id, User user) {
//        userDao.updateUser(id, user);
//    }