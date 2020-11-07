package kpfu.itis.group907.Economic.Dto;

public class DefaultUserDto {
    private String name;
    private String lastName;
    private String email;
    private String login;

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public DefaultUserDto(String name, String lastName, String email, String login) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
    }
}
