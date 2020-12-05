package web.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(int userId) {
        sessionFactory.getCurrentSession().delete(getUser(userId));
    }

    @Override
    public User getUser(int userId) {
        return sessionFactory.getCurrentSession().get(User.class, userId);
    }

    @Override
    public List getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User", User.class).list();
    }
}
