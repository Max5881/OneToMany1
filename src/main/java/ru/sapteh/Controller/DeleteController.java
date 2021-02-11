package ru.sapteh.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.DAO.DAO;
import ru.sapteh.model.User;
import ru.sapteh.service.UserService;

public class DeleteController {

    @FXML
    private TextField deleteIdTextField;

    @FXML
    private Button deleteButton;

    @FXML
    private Button exitButton;

    public void initialize(){

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<User, Integer> userDAO = new UserService(factory);



        deleteButton.setOnAction(event -> {deleteButton.getScene().getWindow().hide();
            User user = new User();

            int ruut = deleteIdTextField.getAnchor();

            userDAO.create(user);

        });
    }
}
