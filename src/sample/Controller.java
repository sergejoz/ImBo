package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.stage.WindowEvent;

public class Controller {

    @FXML
    private AnchorPane pane1;

    @FXML
    private ImageView image1;

    @FXML
    private Label date1;

    @FXML
    private Label nick1;

    @FXML
    private Label title1;

    @FXML
    private ImageView down1;

    @FXML
    private ImageView up1;

    @FXML
    private Label score1;

    @FXML
    private Label tag1;

    @FXML
    private AnchorPane pane2;

    @FXML
    private ImageView image2;

    @FXML
    private Label date2;

    @FXML
    private Label nick2;

    @FXML
    private Label title2;

    @FXML
    private ImageView down2;

    @FXML
    private ImageView up2;

    @FXML
    private Label score2;

    @FXML
    private Label tag2;

    @FXML
    private AnchorPane pane3;

    @FXML
    private ImageView image3;

    @FXML
    private Label date3;

    @FXML
    private Label nick3;

    @FXML
    private Label title3;

    @FXML
    private ImageView down3;

    @FXML
    private ImageView up3;

    @FXML
    private Label score3;

    @FXML
    private Label tag3;

    @FXML
    private AnchorPane pane4;

    @FXML
    private ImageView image4;

    @FXML
    private Label date4;

    @FXML
    private Label nick4;

    @FXML
    private Label title4;

    @FXML
    private ImageView down4;

    @FXML
    private ImageView up4;

    @FXML
    private Label score4;

    @FXML
    private Label tag4;

    @FXML
    private AnchorPane pane5;

    @FXML
    private ImageView image5;

    @FXML
    private Label date5;

    @FXML
    private Label nick5;

    @FXML
    private Label title5;

    @FXML
    private ImageView down5;

    @FXML
    private ImageView up5;

    @FXML
    private Label score5;

    @FXML
    private Label tag5;

    @FXML
    private AnchorPane pane6;

    @FXML
    private ImageView image6;

    @FXML
    private Label date6;

    @FXML
    private Label nick6;

    @FXML
    private Label title6;

    @FXML
    private ImageView down6;

    @FXML
    private ImageView up6;

    @FXML
    private Label score6;

    @FXML
    private Label tag6;

    @FXML
    private ImageView ActiveImage;

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
    private ImageView MyFeedButton;

    @FXML
    private ImageView NewPostsButton;

    @FXML
    private ImageView PopularButton;

    @FXML
    private ImageView SettingsButton;

    @FXML
    private Label CurrentUser;

    FXMLLoader loader;

    public Controller() {
    }

    @FXML
    void MyFeedClicked(MouseEvent event) {

    }

    @FXML
    void NewClicked(MouseEvent event) {

    }

    @FXML
    void initialize() {
        RefreshUsername();

        MyFeedButton.setOnMouseClicked(event ->
        {
            System.out.println("ZDAORVA");

        });

        CurrentUser.setOnMouseClicked(event ->
        {
            if (User.getCurrentUser().getNickname() != null) {
                UserWindowShow();
            } else
                LoginWindowShow();
        });


        NewPostsButton.setOnMouseClicked(event ->
        {
            Posts zpzz = new Posts();
            DatabaseHandler db = new DatabaseHandler();
            try {
                db.getPosts();
                //System.out.println("" + Posts.posts.get(0).tag);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("KTO ETO");
        })
        ;

    }

    private void LoginWindowShow() {
        CurrentUser.getScene().getWindow().hide();
        loader = new FXMLLoader();
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
    }


    private void UserWindowShow() {
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/UserWindow.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
        RefreshUsername();
    }

    public void RefreshUsername() {
        if (User.getCurrentUser().getNickname() != null) {
            this.CurrentUser.setText(User.getCurrentUser().getNickname());
        } else {
            this.CurrentUser.setText("Вход");
        }
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
