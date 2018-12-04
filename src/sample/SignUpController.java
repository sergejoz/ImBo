package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField SignUpLogin;

    @FXML
    private PasswordField SignUpPassword;

    @FXML
    private Button ChoosePic;

    @FXML
    private Button SignUpButton;

    @FXML
    void initialize() {

        SignUpButton.setOnAction(event -> {
            signUpNewUser();

            SignUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/loginform.fxml"));
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


    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String Nickname = SignUpLogin.getText();
        String Password = SignUpLogin.getText();
        User user = new User(Nickname,Password);
        dbHandler.signUpUser(Nickname,Password);
    }
}
