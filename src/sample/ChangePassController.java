package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.Console;

public class ChangePassController {
    @FXML
    private TextField oldpass;
    @FXML
    private TextField newpass1;
    @FXML
    private TextField newpass2;
    @FXML
    private Button changePassButton;
    @FXML
    private Label status;

    @FXML
    void initialize()
    {
        changePassButton.setOnAction(event -> {
            if(!oldpass.getText().equals(User.getCurrentUser().getPassword()))
            {
                status.setText("старый пароль не совпадает,\r\nпопробуйте еще раз");
                status.setVisible(true);
                return;
            }

            if(newpass1.getText().length()==0)
            {
                status.setText("Пароль не может быть пустым");
                status.setVisible(true);
                return;
            }

            if(!newpass1.getText().equals(newpass2.getText()))
            {
                status.setText("введите повторно\r\nновый пароль");
                status.setVisible(true);
                return;
            }

            try
            {
                DatabaseHandler dbHandler = new DatabaseHandler();
                dbHandler.UpdatePassword(User.getCurrentUser().getNickname(),newpass1.getText());
            }
            catch(Exception ex)
            {
                status.setText("Не удалось обновить пароль,\r\nпопробуйте еще раз");
                status.setVisible(true);
            }

            User.getCurrentUser().setPassword(newpass1.getText());
            status.setText("Пароль успешно сохранен");
            status.setVisible(true);
        });


    }
}
