package ru.sapteh.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.DAO.DAO;
import ru.sapteh.model.User;
import ru.sapteh.service.UserService;

public class NewController {

    @FXML
    private Button createButton;

    @FXML
    private Button exitButton;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField firstNameTextField;

    public void initialize(){

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<User, Integer> userDAO = new UserService(factory);

        createButton.setOnAction(event -> {
            createButton.getScene().getWindow().hide();
                userDAO.create(new User(lastNameTextField.getText(),firstNameTextField.getText()));


            });
            exitButton.setOnAction(event -> {
                exitButton.getScene().getWindow().hide();
            });



 }
}
