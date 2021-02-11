package ru.sapteh.service;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.model.User;


import java.util.List;

public class UserService implements DAO<User, Integer> {
    private final SessionFactory factory;

    public UserService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(User user) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public User read(Integer id) {
        try(Session session = factory.openSession()) {
            User result = session.get(User.class,id);

            if (result != null){
                Hibernate.initialize(result.getRoles());
            }
            return result;
        }
    }


    @Override
    public List<User> readAllBy() {
        try (Session session = factory.openSession()) {
            Query<User> result = session.createQuery("FROM User");
            return result.list();
        }
    }

    @Override
    public void update(User user) {
            try(Session session = factory.openSession()) {
                session.beginTransaction();
                session.update(user);
                session.getTransaction().commit();
            }
    }

    @Override
    public void delete(User user) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        }

    }
}
