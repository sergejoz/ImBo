package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UserWindowController {

    @FXML
    private Label usernameLabel;
    @FXML
    private Button createPostButton;
    @FXML
    private Button changePasswordButton;
    @FXML
    private Button exitButton;


    @FXML
    void initialize() {

        if (User.getCurrentUser().getNickname() != null) {
            this.usernameLabel.setText(User.getCurrentUser().getNickname());
        }

        //добавить пост
        createPostButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/CreatePost.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            exitButton.getScene().getWindow().hide();
            stage.show();
            ((Stage) exitButton.getScene().getWindow()).close();
        });

        //сменить пароль
        changePasswordButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/ChangePass.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        //выйти из учетной записи
        exitButton.setOnAction(event -> {
            User.setCurrentUser(new User());
            ((Stage) exitButton.getScene().getWindow()).close();
        });
    }
}
