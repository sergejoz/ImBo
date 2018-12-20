package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Main extends Application {

    public static Window primaryStage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("MegaImageBoard");
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(root, 1085, 700));
        this.primaryStage = primaryStage;
        primaryStage.show();
        Posts pzz = new Posts();
        pzz.setPosts(pzz);
    }


    public static void main(String[] args) {
        launch(args);
    }


}
