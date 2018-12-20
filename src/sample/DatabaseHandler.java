package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.concurrent.BlockingDeque;

public class DatabaseHandler extends Configs {
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

    public void UpdatePassword(String UserNickname, String UserPassword) {
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


    public boolean createPost(String userName, String postHeader, File file) {
        try {
            String query = "INSERT INTO test.posts (user_id,title,image) VALUES((select user_id from users where users.name = '" + userName + "' LIMIT 1),?,?)";
            PreparedStatement pst = getDbConnection().prepareStatement(query);
            pst.setString(1, postHeader);
            FileInputStream fis = new FileInputStream(file);
            pst.setBinaryStream(2, fis, (int) file.length());
            pst.execute();
            pst.close();
        } catch (Exception var5) {
            System.err.println(var5);
            return false;
        }
        return true;
    }

    public String getMaxId() throws SQLException {
        String resault = null;
        Statement pst = getDbConnection().createStatement();
        String maxid = "SELECT MAX(" + Const.POST_ID + ") FROM " + Const.POST_TABLE;
        ResultSet resSet = pst.executeQuery(maxid);
        if (resSet.next()) {
            resault = resSet.getString(1);
        }
        return resault;
    }

    public void getPosts() throws SQLException {
        String maxid = getMaxId();
        String restul= null;
        String needit = maxid;
        //Posts ppp = new Posts();
        Statement pst = getDbConnection().createStatement();
        try {
            String sql = "SELECT title, image, category, date_publish,score, name" +
                    " FROM posts,users" +
                    " WHERE posts.post_id = "  + needit + " AND " +  "users.user_id = posts.user_id";
            ResultSet resSet = pst.executeQuery(sql);
                if (resSet.next()) {
                //String postid = resSet.getString("");
                /*String title = resSet.getString("title");
                Blob blobima = resSet.getBlob("image");
                String date = resSet.getString("date_publish");
                String nickname = resSet.getString("name");
                String tag = resSet.getString("category");
                String rate = resSet.getString("score");*/

                   Posts.postname =  resSet.getString("title");
                   Posts.picture = resSet.getBlob("image");
                   Posts.postdate = resSet.getString("date_publish");
                   Posts.nickname = resSet.getString("name");
                   Posts.tag = resSet.getString("category");
                   Posts.rate = resSet.getString("score");

                //ppp.AddPost(title,nickname,date,blobima,tag,rate);

                }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        /*try (Connection connection = getDbConnection())
        {
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

        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}


