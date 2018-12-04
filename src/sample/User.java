package sample;

public class User {
    private String Nickname;
    private String Password;

    public User(String nickname, String password) {
        Nickname = nickname;
        Password = password;
    }

    public User()
    {}

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
