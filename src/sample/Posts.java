package sample;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Posts {
        private static Posts currPosts = new Posts();

        public static void setPosts(Posts wtf)
        {
            currPosts = wtf;

        }

        public static  Posts getPosts()
        {
            return currPosts;

        }

        public ArrayList<Post> posts = new ArrayList<>();


 public Posts() {

    }


}
