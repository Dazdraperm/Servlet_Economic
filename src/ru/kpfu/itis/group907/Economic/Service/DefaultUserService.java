package kpfu.itis.group907.Economic.Service;

import kpfu.itis.group907.Economic.Models.DefaultUser;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public interface DefaultUserService {
    public DefaultUser get(String login, String password) throws SQLException;
    public void save(DefaultUser defaultUser) throws NoSuchAlgorithmException, SQLException;
}
