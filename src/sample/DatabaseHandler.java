package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;


public class DatabaseHandler extends Configs {
    @FXML
    private ImageView im ;

    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassCastException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName + "?" + "useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    //methods

    public void signUpUser(String UserNickname, String UserPassword) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_NAME + "," + Const.USERS_PASS + ")" + "VALUES (?,?)";
        connectDB(UserNickname, UserPassword, insert);

    }

    public ResultSet getUser(User user) {
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_NAME + "=? AND " + Const.USERS_PASS + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getNickname());
            prSt.setString(2, user.getPassword());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public  void UpdatePassword(String UserNickname, String UserPassword)
    {
        //UPDATE `test`.`users` SET `password` = '1231' WHERE (`user_id` = '1');
        String update = "UPDATE `test`.`users` SET `" + Const.USERS_PASS + "` = '" + UserPassword + "' WHERE (`" + Const.USERS_NAME + "` = '" + UserNickname + "')";
        connectDB1(update);
    }


    private void connectDB1(String command) {
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(command);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void connectDB(String UserNickname, String UserPassword, String command) {
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(command);
            prSt.setString(1, UserNickname);
            prSt.setString(2, UserPassword);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean createPost(String userName, String postHeader, File file)
    {
        try {
            String query = "INSERT INTO test.posts (user_id,title,image) VALUES((select user_id from users where users.name = '" + userName +"' LIMIT 1),?,?)";
            PreparedStatement pst = getDbConnection().prepareStatement(query);
            pst.setString(1, postHeader);
            FileInputStream fis = new FileInputStream(file);
            pst.setBinaryStream(2, fis, (int)file.length());
            pst.execute();
            pst.close();
        } catch (Exception var5) {
            System.err.println(var5);
            return false;
        }
        return true;
    }



}


