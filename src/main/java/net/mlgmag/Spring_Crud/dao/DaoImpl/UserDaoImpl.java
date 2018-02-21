package net.mlgmag.Spring_Crud.dao.DaoImpl;

import net.mlgmag.Spring_Crud.dao.UserDao;
import net.mlgmag.Spring_Crud.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;
    private Transaction transaction;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        session.save(user);

        transaction.commit();
        session.close();
    }

    @Override
    public User getById(UUID uuid) {
        Session session = sessionFactory.openSession();

        User user = session.get(User.class, uuid);

        session.close();

        return user;
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        session.update(user);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        session.delete(user);

        transaction.commit();
        session.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        Session session = sessionFactory.openSession();

        List<User> usersList = session.createQuery("FROM User").list();

        session.close();

        return usersList;
    }

    @Override
    public User findByUsername(String username) {
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("FROM User u WHERE u.username =:username");
        query.setParameter("username", username);

        User user = (User) query.uniqueResult();

        session.close();

        return user;
    }
}
