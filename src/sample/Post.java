package sample;
import javafx.scene.image.Image;

public class Post {
    public String postname;
    public String nickname;
    public String postdate;
    public Image picture;
    public String rate;
    public String tag;
    public String postid;

    public Post()
    {
        //postname = "zhopa";
    }

    public Post(String PostName, String Nickname, String PostDate, Image Picture, String Tag, String Rate, String Postid) {
        postname = PostName;
        nickname = Nickname;
        postdate = PostDate;
        picture = Picture;
        rate = Rate;
        tag = Tag;
        postid = Postid;
    }
}