package sample;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.swing.*;

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
    private ImageView imageView;

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
        String Password = SignUpPassword.getText();
        User user = new User(Nickname, Password);
        user.setCurrentUser(user);
        dbHandler.signUpUser(Nickname, Password);
    }


    private FileChooser fileChooser = new FileChooser();
    private File file;
    private Image image;

    public void browsePic() {
        this.file = this.fileChooser.showOpenDialog(Main.primaryStage);
        if (this.file != null) {
            this.image = new Image(this.file.toURI().toString(), 200.0D, 150.0D, true, true);
            imageView.setImage(this.image);
        }
    }
}
