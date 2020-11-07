package kpfu.itis.group907.Economic.Dao.Impl;

import kpfu.itis.group907.Economic.Dao.DefaultUserDao;
import kpfu.itis.group907.Economic.Helpers.PostgresConnectionHelpers;
import kpfu.itis.group907.Economic.Models.DefaultUser;

import java.sql.*;
import java.util.ArrayList;

public class DefaultUserDaoImpl implements DefaultUserDao {
    private final Connection connection = PostgresConnectionHelpers.getConnection();

    public ArrayList<String> getAll(String login){
        try {
            String sql = "SELECT * FROM DEFAULT_USER WHERE LOGIN LIKE '" + login + "%" + "' LIMIT 3;";
            Statement preparedStatement = connection.createStatement();


            ResultSet resultSet = preparedStatement.executeQuery(sql);
            ArrayList<String> defaultUsers = new ArrayList<>();
            while (resultSet.next()) {
                defaultUsers.add(resultSet.getString("LOGIN"));
            }
            return defaultUsers;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public DefaultUser get(String login, String password) throws SQLException {

        String sql = "SELECT * FROM DEFAULT_USER WHERE EMAIL = '" + login + "';";
        Statement preparedStatement = connection.createStatement();


        ResultSet resultSet = preparedStatement.executeQuery(sql);

        while (resultSet.next()) {
            if (resultSet.getString("PASSWORD").equals(password)) {
                return new DefaultUser(resultSet.getString("LOGIN"),
                        resultSet.getString("PASSWORD"),
                        resultSet.getString("LAST_NAME"),
                        resultSet.getString("FIRST_NAME"),
                        resultSet.getString("EMAIL"));
            }
        }
        return null;
    }



    @Override
    public void save(DefaultUser defaultUser) throws SQLException {
        String sql = "INSERT INTO DEFAULT_USER (login, password, LAST_NAME, FIRST_NAME, EMAIL) VALUES (?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, defaultUser.getLogin());
            preparedStatement.setString(2, defaultUser.getPassword());
            preparedStatement.setString(3, defaultUser.getLAST_NAME());
            preparedStatement.setString(4, defaultUser.getFIRST_NAME());
            preparedStatement.setString(5, defaultUser.getEMAIL());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public DefaultUser baseGet(String login){
        try {
            String sql = "SELECT * FROM DEFAULT_USER WHERE LOGIN = '" + login + "';";
            Statement preparedStatement = connection.createStatement();


            ResultSet resultSet = preparedStatement.executeQuery(sql);

            while (resultSet.next()) {
                return new DefaultUser(resultSet.getString("LOGIN"),
                        resultSet.getString("PASSWORD"),
                        resultSet.getString("LAST_NAME"),
                        resultSet.getString("FIRST_NAME"),
                        resultSet.getString("EMAIL"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean changeUser(String name, String last_name, String new_login, String email, String login){
        String sql = "UPDATE DEFAULT_USER SET login = '" + new_login + "', last_name = '" + last_name + "', first_name = '" + name + "',  email = '" + email + "'WHERE login =  '" + login + "';";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return true;
        }
        catch (SQLException e){
            return false;
        }
    }
}
