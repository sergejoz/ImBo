package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

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
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, UserNickname);
            prSt.setString(2, UserPassword);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
}


