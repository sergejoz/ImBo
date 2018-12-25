package sample;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

import javafx.scene.image.ImageView;

public class CreatePostController {

    @FXML
    private Button publicate;
    @FXML
    private Label headerPost;
    @FXML
    private Button loadImage;
    @FXML
    private ImageView imageView;
    @FXML
    private TextField textBox;
    @FXML
    private Button cancel;
    @FXML
    private Label status;
    @FXML
    private TextField textBox1;

    private FileChooser fileChooser = new FileChooser();
    private File file;
    private Image image;
    private boolean imageIsSet = false;

    @FXML
    void initialize() {

        //публикация поста
        publicate.setOnAction(event -> checkPost());

        //изменение названия поста
        textBox.setOnKeyReleased(event -> changeTextLabel());

        //загрузка изображения на форму
        loadImage.setOnAction(event -> browsePic());

        //отмена
        cancel.setOnAction(event -> ((Stage) cancel.getScene().getWindow()).close());
    }


    private void browsePic() {
        file = fileChooser.showOpenDialog(Main.primaryStage);
        if (file != null) {
            image = new Image(file.toURI().toString());
            imageView.setImage(image);
            imageIsSet = true;
        }
    }

    private void changeTextLabel() {
        headerPost.setText(textBox.getText());
    }

    private void checkPost() {
        status.setVisible(true);
        if (textBox.getText().length() <= 5) {
            status.setText("Название поста должно быть больше пяти символов");
            return;
        }
        if (textBox1.getText().length() <= 2) {
            status.setText("Название категории должно быть больше 2 символов");
            return;
        }
        if (!imageIsSet) {
            status.setText("Вы не выбрали изображение");
            return;
        }
        DatabaseHandler db = new DatabaseHandler();
        if (db.createPost(User.getCurrentUser().getNickname(), headerPost.getText(), file, textBox1.getText())) {
            status.setText("Пост опубликован");
            publicate.setVisible(false);
            loadImage.setVisible(false);
            textBox.setVisible(false);
            cancel.setText("Выход");
        }
        else
        {
            status.setText("Пост не опубликован, возникла ошибка");
        }
    }
}
