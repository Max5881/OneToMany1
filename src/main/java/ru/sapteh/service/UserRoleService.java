package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.model.Role;
import ru.sapteh.model.UserRole;

import java.util.List;

public class UserRoleService implements DAO<UserRole, Integer> {
    private final SessionFactory factory;

    public UserRoleService(SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public void create(UserRole userRole) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(userRole);
            session.getTransaction().commit();
        }

    }

    @Override
    public UserRole read(Integer id) {
        try(Session session = factory.openSession()){
            UserRole result = session.get(UserRole.class,id);

         return result;
        }
    }


    @Override
    public List<UserRole> readAllBy() {
        try (Session session = factory.openSession()){
            Query<UserRole> result = session.createQuery("FROM UserRole");
            return result.list();

        }
    }

    @Override
    public void update(UserRole userRole) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(userRole);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(UserRole userRole) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(userRole);
            session.getTransaction().commit();
        }

    }
}
