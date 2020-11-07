package kpfu.itis.group907.Economic.Dao;

import kpfu.itis.group907.Economic.Models.DefaultUser;

import java.sql.SQLException;

public interface DefaultUserDao {

    public DefaultUser get(String login, String password) throws SQLException;

    public void save(DefaultUser user) throws SQLException;
}
