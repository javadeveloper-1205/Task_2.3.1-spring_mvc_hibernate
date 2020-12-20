package web.dao.impl;

import org.springframework.stereotype.Repository;
import web.dao.UserDao;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public User getUserFromLogin(String name) {
        TypedQuery<User> query =
                entityManager.createQuery( "SELECT user FROM User user WHERE user.name =:username", User.class);
        return query.setParameter("username", name).getSingleResult();
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        Query query = entityManager.createQuery("delete from User " +
                "where id =:userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }
}
























//    @Override
//    public User getUserFromLogin(String name) {
//        String searchQuery = "select * from User where name='" + name + "')";
//        Query query = entityManager.createQuery(searchQuery);
//        query.setParameter("login", name);
//        query.executeUpdate();
//        return (User) query;
//    }
