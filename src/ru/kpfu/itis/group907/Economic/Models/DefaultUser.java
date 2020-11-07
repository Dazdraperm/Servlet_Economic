package kpfu.itis.group907.Economic.Models;

public class DefaultUser {
    private String EMAIL;
    private Integer id;
    private String login;
    private String password;
    private String LAST_NAME;
    private String FIRST_NAME;



    public DefaultUser(String login, String password, String LAST_NAME, String FIRST_NAME, String EMAIL){
        this.login = login;
        this.password = password;
        this.LAST_NAME = LAST_NAME;
        this.FIRST_NAME = FIRST_NAME;
        this.EMAIL = EMAIL;
    }

    @Override
    public String toString() {
        return "DefaultUser{" +
                "EMAIL='" + EMAIL + '\'' +
                ", id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", LAST_NAME='" + LAST_NAME + '\'' +
                ", FIRST_NAME='" + FIRST_NAME + '\'' +
                '}';
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }



}
