package sample;

public class User {
    public User()
    {}
    public User(String nickname, String password) {
        Nickname = nickname;
        Password = password;
    }

    private static User CURRENT_USER = new User();
    private String Nickname;
    private String Password;
    private String UserType;//тип пользователя: админ = 0, модератор = 1, юзер = 2

    public static void setCurrentUser(User user) {
        CURRENT_USER = user;
        System.out.println("User has been set");
    }

    public static User getCurrentUser() {
        System.out.println("User has been get");
        return CURRENT_USER;
    }

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
