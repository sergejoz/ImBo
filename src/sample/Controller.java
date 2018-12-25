package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.sun.javafx.image.IntPixelGetter;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.stage.WindowEvent;

public class Controller {


    //region PEREMENNIE
    @FXML
    private AnchorPane pane1;

    @FXML
    private Label Page1;

    @FXML
    private Label Page2;

    @FXML
    private Label Page3;

    @FXML
    private Label Page4;

    @FXML
    private Label Page5;

    @FXML
    private Label DotaCat;

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
    private ImageView ActiveUpButton;

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

    @FXML
    private Label AwwCat;

    @FXML
    private Label CatsCat;

    @FXML
    private Label CosplayCat;

    @FXML
    private Label animecat;


    FXMLLoader loader;

    public Controller() {

    }

    @FXML
    void MyFeedClicked(MouseEvent event) {

    }

    @FXML
    void NewClicked(MouseEvent event) {

    }

    //endregion
    private int CurrId = 0;
    private boolean first = true;
    private int PageId = 1;

    private String TIP = "popular"; // popular, new, category

    @FXML
    void initialize() {
        final Glow glow = new Glow(1);
        RefreshUsername();


        if (first) {
            DatabaseHandler db = new DatabaseHandler();
            try {
                db.getPopular(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            UpdateForm();
            first = false;
            ActivePosts(0);
        }

        //region PAGEBUTTONS
        Page1.setOnMouseClicked(event ->
                {
                    PageId = 1;
                    UpdateFormByPage();
                    UpdatePageCounts();
                }
        );

        Page2.setOnMouseClicked(event ->
                {
                    PageId = 2;
                    UpdateFormByPage();
                    UpdatePageCounts();
                }
        );

        Page3.setOnMouseClicked(event ->
                {
                    PageId = 3;
                    UpdateFormByPage();
                    UpdatePageCounts();
                }
        );

        Page4.setOnMouseClicked(event ->
                {
                    PageId = 4;
                    UpdateFormByPage();
                    UpdatePageCounts();
                }
        );

        Page5.setOnMouseClicked(event ->
                {
                    PageId = 5;
                    UpdateFormByPage();
                    UpdatePageCounts();
                }
        );
        //endregion

        PopularButton.setOnMouseClicked(event ->
        {
            TIP = "popular";
            DatabaseHandler db = new DatabaseHandler();
            try {
                db.getPopular(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            UpdateForm();
        });

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

        //region CATEGOREIS
        DotaCat.setOnMouseClicked(event ->
        {
            TIP = "DOTA";
            UpdateFormByPage();
        });

        AwwCat.setOnMouseClicked(event ->
        {
            TIP = "aww";
            UpdateFormByPage();
        });

        animecat.setOnMouseClicked(event ->
        {
            TIP = "anime";
            UpdateFormByPage();
        });

        CosplayCat.setOnMouseClicked(event ->
        {
            TIP = "cosplay";
            UpdateFormByPage();
        });

        CatsCat.setOnMouseClicked(event ->
        {
            TIP = "cats";
            UpdateFormByPage();
        });
        //endregion

        //region VOTING
        up1.setOnMouseClicked(event ->
        {
            if (User.getCurrentUser().getNickname() == null) return;
            DatabaseHandler db = new DatabaseHandler();
            Post post1 = Posts.getPosts().posts.get(0);
            Integer i = Integer.parseInt(post1.rate.trim());
            ++i;
            score1.setText(i.toString());
            up1.setDisable(true);
            down1.setDisable(false);
            db.UpdateVote(post1.postid, i.toString());
            up1.setEffect(glow);
            down1.setEffect(null);
            post1.rate = i.toString();
        });

        down1.setOnMouseClicked(event ->
        {
            if (User.getCurrentUser().getNickname() == null) return;
            DatabaseHandler db = new DatabaseHandler();
            Post post1 = Posts.getPosts().posts.get(0);
            Integer i = Integer.parseInt(post1.rate.trim());
            --i;
            score1.setText(i.toString());
            up1.setDisable(false);
            down1.setDisable(true);
            String ifin = i.toString();
            db.UpdateVote(post1.postid, i.toString());
            down1.setEffect(glow);
            up1.setEffect(null);
            post1.rate = i.toString();
        });

        up2.setOnMouseClicked(event ->
        {
            if (User.getCurrentUser().getNickname() == null) return;
            DatabaseHandler db = new DatabaseHandler();
            Post post1 = Posts.getPosts().posts.get(1);
            Integer i = Integer.parseInt(post1.rate.trim());
            ++i;
            score2.setText(i.toString());
            up2.setDisable(true);
            down2.setDisable(false);
            db.UpdateVote(post1.postid, i.toString());
            up2.setEffect(glow);
            down2.setEffect(null);
            post1.rate = i.toString();
        });

        down2.setOnMouseClicked(event ->
        {
            if (User.getCurrentUser().getNickname() == null) return;
            DatabaseHandler db = new DatabaseHandler();
            Post post1 = Posts.getPosts().posts.get(1);
            Integer i = Integer.parseInt(post1.rate.trim());
            --i;
            score2.setText(i.toString());
            up2.setDisable(false);
            down2.setDisable(true);
            String ifin = i.toString();
            db.UpdateVote(post1.postid, i.toString());
            down2.setEffect(glow);
            up2.setEffect(null);
            post1.rate = i.toString();
        });


        up3.setOnMouseClicked(event ->
        {
            if (User.getCurrentUser().getNickname() == null) return;
            DatabaseHandler db = new DatabaseHandler();
            Post post1 = Posts.getPosts().posts.get(2);
            Integer i = Integer.parseInt(post1.rate.trim());
            ++i;
            score3.setText(i.toString());
            up3.setDisable(true);
            down3.setDisable(false);
            db.UpdateVote(post1.postid, i.toString());
            up3.setEffect(glow);
            down3.setEffect(null);
            post1.rate = i.toString();
        });

        down3.setOnMouseClicked(event ->
        {
            if (User.getCurrentUser().getNickname() == null) return;
            DatabaseHandler db = new DatabaseHandler();
            Post post1 = Posts.getPosts().posts.get(2);
            Integer i = Integer.parseInt(post1.rate.trim());
            --i;
            score3.setText(i.toString());
            up3.setDisable(false);
            down3.setDisable(true);
            String ifin = i.toString();
            db.UpdateVote(post1.postid, i.toString());
            down3.setEffect(glow);
            up3.setEffect(null);
            post1.rate = i.toString();
        });

        up4.setOnMouseClicked(event ->
        {
            if (User.getCurrentUser().getNickname() == null) return;
            DatabaseHandler db = new DatabaseHandler();
            Post post1 = Posts.getPosts().posts.get(3);
            Integer i = Integer.parseInt(post1.rate.trim());
            ++i;
            score4.setText(i.toString());
            up4.setDisable(true);
            down4.setDisable(false);
            db.UpdateVote(post1.postid, i.toString());
            up4.setEffect(glow);
            down4.setEffect(null);
            post1.rate = i.toString();
        });

        down4.setOnMouseClicked(event ->
        {
            if (User.getCurrentUser().getNickname() == null) return;
            DatabaseHandler db = new DatabaseHandler();
            Post post1 = Posts.getPosts().posts.get(3);
            Integer i = Integer.parseInt(post1.rate.trim());
            --i;
            score4.setText(i.toString());
            up4.setDisable(false);
            down4.setDisable(true);
            String ifin = i.toString();
            db.UpdateVote(post1.postid, i.toString());
            down4.setEffect(glow);
            up4.setEffect(null);
            post1.rate = i.toString();
        });

        up5.setOnMouseClicked(event ->
        {
            if (User.getCurrentUser().getNickname() == null) return;
            DatabaseHandler db = new DatabaseHandler();
            Post post1 = Posts.getPosts().posts.get(4);
            Integer i = Integer.parseInt(post1.rate.trim());
            ++i;
            score5.setText(i.toString());
            up5.setDisable(true);
            down5.setDisable(false);
            db.UpdateVote(post1.postid, i.toString());
            up5.setEffect(glow);
            down5.setEffect(null);
            post1.rate = i.toString();
        });

        down5.setOnMouseClicked(event ->
        {
            if (User.getCurrentUser().getNickname() == null) return;
            DatabaseHandler db = new DatabaseHandler();
            Post post1 = Posts.getPosts().posts.get(4);
            Integer i = Integer.parseInt(post1.rate.trim());
            --i;
            score5.setText(i.toString());
            up5.setDisable(false);
            down5.setDisable(true);
            String ifin = i.toString();
            db.UpdateVote(post1.postid, i.toString());
            down5.setEffect(glow);
            up5.setEffect(null);
            post1.rate = i.toString();
        });

        up6.setOnMouseClicked(event ->
        {
            if (User.getCurrentUser().getNickname() == null) return;
            DatabaseHandler db = new DatabaseHandler();
            Post post1 = Posts.getPosts().posts.get(5);
            Integer i = Integer.parseInt(post1.rate.trim());
            ++i;
            score6.setText(i.toString());
            up6.setDisable(true);
            down6.setDisable(false);
            db.UpdateVote(post1.postid, i.toString());
            up6.setEffect(glow);
            down6.setEffect(null);
            post1.rate = i.toString();
        });

        down6.setOnMouseClicked(event ->
        {
            if (User.getCurrentUser().getNickname() == null) return;
            DatabaseHandler db = new DatabaseHandler();
            Post post1 = Posts.getPosts().posts.get(5);
            Integer i = Integer.parseInt(post1.rate.trim());
            --i;
            score6.setText(i.toString());
            up6.setDisable(false);
            down6.setDisable(true);
            String ifin = i.toString();
            db.UpdateVote(post1.postid, i.toString());
            down6.setEffect(glow);
            up6.setEffect(null);
            post1.rate = i.toString();
        });

        ActiveDownButton.setOnMouseClicked(event ->
                {
                    if (User.getCurrentUser().getNickname() == null) return;
                    DatabaseHandler db = new DatabaseHandler();
                    Post post1 = Posts.getPosts().posts.get(CurrId);
                    Integer i = Integer.parseInt(post1.rate.trim());
                    --i;
                    ActiveRate.setText(i.toString());
                    ActiveUpButton.setDisable(false);
                    ActiveDownButton.setDisable(true);
                    db.UpdateVote(post1.postid, i.toString());
                    ActiveDownButton.setEffect(glow);
                    ActiveUpButton.setEffect(null);
                    post1.rate = i.toString();
                }
        );

        ActiveUpButton.setOnMouseClicked(event ->
        {
            if (User.getCurrentUser().getNickname() == null) return;
            DatabaseHandler db = new DatabaseHandler();
            Post post1 = Posts.getPosts().posts.get(CurrId);
            Integer i = Integer.parseInt(post1.rate.trim());
            ++i;
            ActiveRate.setText(i.toString());
            ActiveUpButton.setDisable(true);
            ActiveDownButton.setDisable(false);
            db.UpdateVote(post1.postid, i.toString());
            ActiveUpButton.setEffect(glow);
            ActiveDownButton.setEffect(null);
            post1.rate = i.toString();

        });
        //endregion

        //region OPENACTIVE
        image1.setOnMouseClicked(event ->
        {
            ActivePosts(0);

        });

        image2.setOnMouseClicked(event ->
        {
            ActivePosts(1);
        });

        image3.setOnMouseClicked(event ->
        {
            ActivePosts(2);
        });

        image4.setOnMouseClicked(event ->
        {
            ActivePosts(3);
        });

        image5.setOnMouseClicked(event ->
        {
            ActivePosts(4);
        });

        image6.setOnMouseClicked(event ->
        {
            ActivePosts(5);
        });

        title1.setOnMouseClicked(event ->
        {
            ActivePosts(0);

        });

        title2.setOnMouseClicked(event ->
        {
            ActivePosts(1);
        });

        title3.setOnMouseClicked(event ->
        {
            ActivePosts(2);
        });

        title4.setOnMouseClicked(event ->
        {
            ActivePosts(3);
        });

        title5.setOnMouseClicked(event ->
        {
            ActivePosts(4);
        });

        title6.setOnMouseClicked(event ->
        {
            ActivePosts(5);
        });
//endregion

        NewPostsButton.setOnMouseClicked(event ->
                {
                    DatabaseHandler db = new DatabaseHandler();

                    try {
                        db.getPosts(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    UpdateForm();
                }
        )
        ;
    }

    public void centerImage() {
        Image img = ActiveImage.getImage();
        if (img != null) {
            double w = 0;
            double h = 0;

            double ratioX = ActiveImage.getFitWidth() / img.getWidth();
            double ratioY = ActiveImage.getFitHeight() / img.getHeight();

            double reducCoeff = 0;
            if(ratioX >= ratioY) {
                reducCoeff = ratioY;
            } else {
                reducCoeff = ratioX;
            }

            w = img.getWidth() * reducCoeff;
            h = img.getHeight() * reducCoeff;

            ActiveImage.setX((ActiveImage.getFitWidth() - w) / 2);
            ActiveImage.setY((ActiveImage.getFitHeight() - h) / 2);

        }
    }

    private void UpdateFormByPage() {
        if (TIP == "popular") {
            DatabaseHandler db = new DatabaseHandler();
            try {
                db.getPopular(PageId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (TIP == "new") {
            DatabaseHandler db = new DatabaseHandler();
            try {
                db.getPosts(PageId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (TIP != "new" && TIP != "popular") {
            DatabaseHandler db = new DatabaseHandler();
            try {
                db.getPostsbyCategory(PageId, TIP);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        UpdateForm();
    }

    private void UpdatePageCounts() {
        Page1.setTextFill(Color.web("#8a8a8a"));
        Page2.setTextFill(Color.web("#8a8a8a"));
        Page3.setTextFill(Color.web("#8a8a8a"));
        Page4.setTextFill(Color.web("#8a8a8a"));
        Page5.setTextFill(Color.web("#8a8a8a"));

        switch (PageId) {
            case (1): {
                Page1.setTextFill(Color.web("#FFFFFF"));
                break;
            }
            case (2): {
                Page2.setTextFill(Color.web("#FFFFFF"));
                break;
            }
            case (3): {
                Page3.setTextFill(Color.web("#FFFFFF"));
                break;
            }
            case (4): {
                Page4.setTextFill(Color.web("#FFFFFF"));
                break;
            }
            case (5): {
                Page5.setTextFill(Color.web("#FFFFFF"));
                break;
            }
        }
    }

    private void UpdateForm() {
        //region GOTOVNOST
        pane1.setVisible(false);
        pane2.setVisible(false);
        pane3.setVisible(false);
        pane4.setVisible(false);
        pane5.setVisible(false);
        pane6.setVisible(false);
        up1.setDisable(false);
        up1.setEffect(null);
        up2.setDisable(false);
        up2.setEffect(null);
        up3.setDisable(false);
        up3.setEffect(null);
        up4.setDisable(false);
        up4.setEffect(null);
        up5.setDisable(false);
        up5.setEffect(null);
        up6.setDisable(false);
        up6.setEffect(null);
        down1.setDisable(false);
        down1.setEffect(null);
        down2.setDisable(false);
        down2.setEffect(null);
        down3.setDisable(false);
        down3.setEffect(null);
        down4.setDisable(false);
        down4.setEffect(null);
        down5.setDisable(false);
        down5.setEffect(null);
        down6.setDisable(false);
        down6.setEffect(null);
        //endregion
        int postscount = Posts.getPosts().posts.size();

        if (postscount > 0) {
            Post post1 = Posts.getPosts().posts.get(0);
            title1.setText(post1.postname);
            nick1.setText(post1.nickname);
            date1.setText(post1.postdate);
            tag1.setText(post1.tag);
            image1.setImage(post1.picture);
            score1.setText(post1.rate);
            pane1.setVisible(true);

        }

        //post2
        if (postscount > 1) {
            Post post2 = Posts.getPosts().posts.get(1);
            title2.setText(post2.postname);
            nick2.setText(post2.nickname);
            date2.setText(post2.postdate);
            tag2.setText(post2.tag);
            image2.setImage(post2.picture);
            score2.setText(post2.rate);
            pane2.setVisible(true);
        }
        //post3
        if (postscount > 2) {
            Post post3 = Posts.getPosts().posts.get(2);
            title3.setText(post3.postname);
            nick3.setText(post3.nickname);
            date3.setText(post3.postdate);
            tag3.setText(post3.tag);
            image3.setImage(post3.picture);
            score3.setText(post3.rate);
            pane3.setVisible(true);
        }
        //post4
        if (postscount > 3) {
            Post post4 = Posts.getPosts().posts.get(3);
            title4.setText(post4.postname);
            nick4.setText(post4.nickname);
            date4.setText(post4.postdate);
            tag4.setText(post4.tag);
            image4.setImage(post4.picture);
            score4.setText(post4.rate);
            pane4.setVisible(true);
        }
        //post5
        if (postscount > 4) {
            Post post5 = Posts.getPosts().posts.get(4);
            title5.setText(post5.postname);
            nick5.setText(post5.nickname);
            date5.setText(post5.postdate);
            tag5.setText(post5.tag);
            image5.setImage(post5.picture);
            score5.setText(post5.rate);
            pane5.setVisible(true);
        }
        //post6
        if (postscount > 5) {
            Post post6 = Posts.getPosts().posts.get(5);
            title6.setText(post6.postname);
            nick6.setText(post6.nickname);
            date6.setText(post6.postdate);
            tag6.setText(post6.tag);
            image6.setImage(post6.picture);
            score6.setText(post6.rate);
            pane6.setVisible(true);
        }
    }

    private void ActivePosts(Integer a) {
        Post post1 = Posts.getPosts().posts.get(a);
        ActiveImage.setImage(post1.picture);
        ActiveTitle.setText(post1.postname);
        ActiveNickname.setText(post1.nickname);
        ActiveDate.setText(post1.postdate);
        ActiveTag.setText(post1.tag);
        ActiveRate.setText(post1.rate);
        CurrId = a;
        centerImage();
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
