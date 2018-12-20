package sample;

import com.mysql.cj.jdbc.Blob;

import java.util.ArrayList;

public class Posts {
    public static String postname;
    public static String nickname;
    public static String postdate;
    public static java.sql.Blob picture;
    public static String rate;
    public static String tag;
/*    public static ArrayList<Post> posts = new ArrayList<>();
    private static String govno;

    public Posts() {
    }

    public void AddPost(String PostName, String Nickname, String PostDate, java.sql.Blob Picture, String Tag, String Rate) {
        Post postx = new Post(PostName, Nickname, PostDate, Picture, Tag, Rate);
        posts.add(postx);
    }

    public String GetNickname(Integer ind) {
        String result = posts.get(0).ReturnNickname();
        return result;
    }

    public void SetGovno(String wtf)
    {
        govno = wtf;

    }

    public String getGovno()
    {
        return govno;

    }*/

    /*public class Post {
        public static String postname;
        public  String nickname;
        public String postdate;
        public java.sql.Blob picture;
        public String rate;
        public String tag;

        public Post(String PostName, String Nickname, String PostDate, java.sql.Blob Picture, String Tag, String Rate) {
            PostName = postname;
            Nickname = nickname;
            PostDate = postdate;
            Picture = picture;
            Rate = rate;
            Tag = tag;
        }

        public String ReturnNickname() {
            return nickname;
        }*/
    }
}
