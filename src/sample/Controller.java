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
            DatabaseHandler db = new DatabaseHandler();

            try {
                db.getPosts();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("KTO ETO");
            //post1
            Post post1 = Posts.getPosts().posts.get(0);
            title1.setText(post1.postname);
            nick1.setText(post1.nickname);
            date1.setText(post1.postdate);
            tag1.setText(post1.tag);
            image1.setImage(post1.picture);
            score1.setText(post1.rate);

            //post2
            Post post2 = Posts.getPosts().posts.get(1);
            title2.setText(post2.postname);
            nick2.setText(post2.nickname);
            date2.setText(post2.postdate);
            tag2.setText(post2.tag);
            image2.setImage(post2.picture);
            score2.setText(post2.rate);

            //post3
            Post post3 = Posts.getPosts().posts.get(2);
            title3.setText(post3.postname);
            nick3.setText(post3.nickname);
            date3.setText(post3.postdate);
            tag3.setText(post3.tag);
            image3.setImage(post3.picture);
            score3.setText(post3.rate);

            //post4
            Post post4 = Posts.getPosts().posts.get(3);
            title4.setText(post4.postname);
            nick4.setText(post4.nickname);
            date4.setText(post4.postdate);
            tag4.setText(post4.tag);
            image4.setImage(post4.picture);
            score4.setText(post4.rate);

            //post5
            Post post5 = Posts.getPosts().posts.get(4);
            title5.setText(post5.postname);
            nick5.setText(post5.nickname);
            date5.setText(post5.postdate);
            tag5.setText(post5.tag);
            image5.setImage(post5.picture);
            score5.setText(post5.rate);

            //post6
            Post post6 = Posts.getPosts().posts.get(5);
            title6.setText(post6.postname);
            nick6.setText(post6.nickname);
            date6.setText(post6.postdate);
            tag6.setText(post6.tag);
            image6.setImage(post6.picture);
            score6.setText(post6.rate);
        }

        )
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
