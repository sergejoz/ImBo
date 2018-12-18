package sample;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.imageio.*;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

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
    private Label nick;

    @FXML
    private ImageView imagep ;

    @FXML
    private Label titlep ;

    @FXML
    private Label datep ;

    @FXML
    private Label nickp ;

    @FXML
    private Label tagp ;

    FXMLLoader loader;

    public Controller() {
    }

    @FXML
    void MyFeedClicked(MouseEvent event)  throws SQLException, ClassNotFoundException {
        print_post();
    }

    @FXML
    void NewClicked(MouseEvent event) {

    }

    @FXML
    void initialize() {
        RefreshUsername();

        PopularButton.setOnMouseClicked(event ->
                {
                    
                });



        MyFeedButton.setOnMouseClicked(event ->
        {

            System.out.println("ZDAORVA");
        });

        CurrentUser.setOnMouseClicked(event ->
        {
            if(User.getCurrentUser().getNickname()!=null)
            {
                UserWindowShow();
            }
            else
            LoginWindowShow();
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

    private void LoginWindowShow()
    {
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


    private void UserWindowShow()
    {
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

    public void RefreshUsername()
    {
        if(User.getCurrentUser().getNickname()!=null)
        {
            this.CurrentUser.setText(User.getCurrentUser().getNickname());
        }
        else
        {
            this.CurrentUser.setText("Вход");
        }
    }

    public void MyFeedClicked() {
        //System.out.println("FEED");

    }



    public void NewClicked() {
        //System.out.println("NEW");
    }

    public void print_post () throws SQLException, ClassNotFoundException {
        //nick.setText("fuckyou");
        String userName = "root";
        String password = "0000";
        String connectionUrl = "jdbc:mysql://localhost:3306/test?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName,password)) {
            Statement mystm = connection.createStatement();
            String sql = "Select image from posts order by post_id desc limit 1"; //импорт картинки
            ResultSet resultSet = mystm.executeQuery(sql);
            while (resultSet.next()) {
                Blob blob = resultSet.getBlob("image");
                BufferedImage Bimage = ImageIO.read(blob.getBinaryStream());
                Image image = SwingFXUtils.toFXImage(Bimage, null);
                imagep.setImage(image);
            }
            String sql1 = "Select title from posts order by post_id desc limit 1";
            ResultSet resultSet1 = mystm.executeQuery(sql1);
            if (resultSet1.next()) {
                titlep.setText( resultSet1.getString(1));
            }

            String sql2 = "Select users.name from posts join users where posts.user_id = users.user_id order by post_id desc limit 1";
            ResultSet resultSet2 = mystm.executeQuery(sql2);
            if (resultSet2.next()) {
                nickp.setText( resultSet2.getString(1));
            }

            String sql3 = "Select date(date_publish) from posts  order by post_id desc limit 1";
            ResultSet resultSet3 = mystm.executeQuery(sql3);
            if (resultSet3.next()) {
                datep.setText( resultSet3.getString(1));
            }

            String sql4 = "Select category from posts  order by post_id desc limit 1";
            ResultSet resultSet4 = mystm.executeQuery(sql4);
            if (resultSet4.next()) {
                tagp.setText( resultSet4.getString(1));
            }

          //  nick.setText(resultSet1.getString(1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
