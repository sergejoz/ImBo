package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label ActiveNickname;

    @FXML
    private Label ActiveDate;

    @FXML
    private Label ActiveTitle;

    @FXML
    private Label ActiveTag;

    @FXML
    private ImageView ActiveDownButton;

    @FXML
    private ImageView ActveUpButton;

    @FXML
    private Label ActiveRate;

    @FXML
    private TextField SearchField;

    @FXML
    private ImageView MyFeedButton;

    @FXML
    private ImageView NewPostsButton;

    @FXML
    private ImageView PopularButton;

    @FXML
    private ImageView SettingsButton;

    @FXML
    private Label CurrentUser;

    @FXML
    void MyFeedClicked(MouseEvent event) {

    }

    @FXML
    void NewClicked(MouseEvent event) {

    }

    @FXML
    void initialize() {
        MyFeedButton.setOnMouseClicked(event ->
        {
            System.out.println("ZDAORVA");
        });

        CurrentUser.setOnMouseClicked(event ->
        {
            CurrentUser.getScene().getWindow().hide();
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

        NewPostsButton.setOnMouseClicked(event ->
        {
           // User user = new User();
         //CurrentUser.setText(user.getNickname());
         System.out.println("KTO ETO");
         //   System.out.println(user.getNickname());
        })
        ;

    }

    public void MyFeedClicked() {
        //System.out.println("FEED");

    }

    public void HotClicked() {
        //System.out.println("HOT");

    }

    public void NewClicked() {
        //System.out.println("NEW");
    }
}
