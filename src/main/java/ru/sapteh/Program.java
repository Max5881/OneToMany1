package ru.sapteh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.DAO.DAO;
import ru.sapteh.model.Role;
import ru.sapteh.model.User;
import ru.sapteh.model.UserRole;
import ru.sapteh.service.RoleService;
import ru.sapteh.service.UserRoleService;
import ru.sapteh.service.UserService;

import java.util.Set;

public class Program {
    public static void main(String[] args) {
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//        DAO<Role,Integer> roleDAO = new RoleService(factory);
//        DAO<User,Integer> userDAO = new UserService(factory);
//        DAO<UserRole, Integer> userRoleDAO = new UserRoleService(factory);
//
//        User user = new User();
//
//
//        user.setFirstName("Lin");
//        user.setLastName("Nin");
//
//        userDAO.create(user);
//
//        Role role = new Role();
//        UserRole userRole = new UserRole();
//
//        role.setNameRoles("Adminchik");
//
//        roleDAO.create(role);
//
//        System.out.println(userRoleDAO.read(1));
    }
}
