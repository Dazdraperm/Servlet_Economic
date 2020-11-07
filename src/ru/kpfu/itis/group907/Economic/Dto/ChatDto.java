package kpfu.itis.group907.Economic.Dto;

public class ChatDto {
    private String login_user;
    private String text;

    public String getLogin_user() {
        return login_user;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "ChatDto{" +
                "login_user='" + login_user + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public ChatDto(String login_user, String text) {
        this.login_user = login_user;
        this.text = text;
    }
}
