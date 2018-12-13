package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginformController {

    @FXML
    private PasswordField password_field;

    @FXML
    private TextField login_field;

    @FXML
    private Button LogInButton;

    @FXML
    private Button SignUpButton;

    @FXML
    void initialize() {

        SignUpButton.setOnMouseClicked(event ->
        {
            SignUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/signupform.fxml"));
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

        LogInButton.setOnAction(event ->
        {
            String loginText = login_field.getText().trim();
            String loginPassword = password_field.getText().trim();
            if (!loginText.equals("") && !loginPassword.equals(""))
                LoginUser(loginText, loginPassword);
            else
                System.out.println("Error");

        });
    }

    private void LoginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setCurrentUser(user);//запоминаем текщего пользователя
        user.setNickname(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        try {
            while (result.next()) {
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (counter >= 1) {
            System.out.println("EASY!");
            user.setNickname(loginText);
            LogInButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/sample.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        } else {
            System.out.println("NEVERNO, BRAT");
            user.setNickname("");
            user.setPassword("");

        }
    }
}
