package ru.sapteh.Controller;


import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Fxml;
import ru.sapteh.model.Role;
import ru.sapteh.model.User;
import ru.sapteh.model.UserRole;
import ru.sapteh.service.RoleService;
import ru.sapteh.service.UserRoleService;
import ru.sapteh.service.UserService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

public class OverViewController {

    ObservableList<User> userList = FXCollections.observableArrayList();
    ObservableList<Role> rolesList = FXCollections.observableArrayList();
    ObservableList<UserRole> userRolesList = FXCollections.observableArrayList();

    @FXML
    private TableView<User> userTableView;

    @FXML
    private TableView<Role> tableViewRole;

    @FXML
    private TableView<UserRole> tableViewUserRole;

    @FXML
    private TableColumn<User, Integer> idColumn;

    @FXML
    private TableColumn<User, String> lastNameColumn;

    @FXML
    private TableColumn<User, String> firstNameColumn;

    @FXML
    private Button newUserButton;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButtonUser;

    @FXML
    private TableColumn<Role, Integer> ifColumnRole;

    @FXML
    private TableColumn<Role, String> nameRolesColumnRole;

    @FXML
    private TableColumn<UserRole,Integer> idColumnUserRole;

    @FXML
    private TableColumn<UserRole, String> registrationDateColumnUserRole;

    @FXML
    private TableColumn<UserRole, Integer> roleIdColumnUserRole;

    @FXML
    private TableColumn<UserRole, Integer> userIdColumnUserRole;

    @FXML
    private Label countRoleLabel;

    @FXML
    private Label dateRegistrationLabel;

    @FXML
    public void initialize() throws IOException {
        User user = new User();

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<User, Integer> userDAO = new UserService(factory);
        DAO<Role, Integer> roleDAO = new RoleService(factory);
        DAO<UserRole, Integer> userRoleDAO = new UserRoleService(factory);

        List<Role> roleList = roleDAO.readAllBy();

        rolesList.addAll(roleList);

        List<UserRole> userRoles = userRoleDAO.readAllBy();

        userRolesList.addAll(userRoles);

        List<User> userDataBase = userDAO.readAllBy();

        userList.addAll(userDataBase);

        idColumn.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getId()));
        lastNameColumn.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getLastName()));
        firstNameColumn.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getFirstName()));


        userTableView.setItems(userList);

        ifColumnRole.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getId()));
        nameRolesColumnRole.setCellValueFactory(p-> new SimpleObjectProperty<>(p.getValue().getNameRoles()));

        tableViewRole.setItems(rolesList);

        idColumnUserRole.setCellValueFactory(p-> new SimpleObjectProperty<>(p.getValue().getId()));
        registrationDateColumnUserRole.setCellValueFactory(p-> new SimpleObjectProperty<>(p.getValue().getDateRegistration()));
        roleIdColumnUserRole.setCellValueFactory(p-> new SimpleObjectProperty<>(p.getValue().getRole().getId()));
        userIdColumnUserRole.setCellValueFactory(p-> new SimpleObjectProperty<>(p.getValue().getUser().getId()));

        tableViewUserRole.setItems(userRolesList);


        newUserButton.setOnAction(event -> {newUserButton.getScene().getWindow();
        try{
            URL url = new File("c:/java_42/OneToMany1/src/main/java/ru/sapteh/view/NewView.fxml").toURI().toURL();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(url);
            stage.setTitle("New user");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        });

        factory.close();

        deleteButtonUser.setOnAction(event -> {deleteButtonUser.getScene().getWindow();
        try {
            URL url = new File("c:/java_42/OneToMany1/src/main/java/ru/sapteh/view/DeleteView.fxml").toURI().toURL();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(url);
            stage.setTitle("Delete User");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        });



    }

}
