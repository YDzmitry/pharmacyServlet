package com.vironit.pharmacy.dao;

import com.vironit.pharmacy.exception.CustomGenericException;
import com.vironit.pharmacy.model.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User create(User user) throws CustomGenericException {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction trans=session.beginTransaction();
        session.save(user);
        trans.commit();
        logger.info("Person saved successfully, Person Details=" + user);
        return user;
    }

    @Override
    public List<User> getAll() throws CustomGenericException {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> usersList = session.createQuery("from User").list();
        for (User user : usersList) {
            logger.info("Person List::" + user);
        }
        return usersList;
    }

    @Override
    public User getByPK(Integer key) throws CustomGenericException {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, new Integer(key));
        transaction.commit();
        logger.info("Person loaded successfully, Person details=" + key);
        return user;
    }

    @Override
    public void update(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("Person updated successfully, Person Details=" + user);
    }

    @Override
    public void delete(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        if (null != user.getId()) {
            session.delete(user);
        }
        logger.info("Person deleted successfully, person details=" + user);
    }
}
