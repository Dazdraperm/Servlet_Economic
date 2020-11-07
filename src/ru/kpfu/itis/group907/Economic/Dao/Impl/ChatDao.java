package kpfu.itis.group907.Economic.Dao.Impl;

import kpfu.itis.group907.Economic.Dto.ChatDto;
import kpfu.itis.group907.Economic.Helpers.PostgresConnectionHelpers;
import java.util.Date;
import java.sql.*;
import java.util.ArrayList;

public class ChatDao {
    private final Connection connection = PostgresConnectionHelpers.getConnection();

    private Integer id_user_1;
    private Integer id_user_2;
    private String login_user_1;
    private String login_user_2;

    public ChatDao(String login_user_1, String login_user_2) {
        this.id_user_1 = Integer.parseInt(giveId(login_user_1));
        this.id_user_2 = Integer.parseInt(giveId(login_user_2));
        this.login_user_1 = login_user_1;
        this.login_user_2 = login_user_2;
    }

    public ChatDao(String login_user_1) {
        this.login_user_1 = login_user_1;
        this.id_user_1 = Integer.parseInt(giveId(login_user_1));

    }

    public void createMessage(String message){
        String sql = "INSERT INTO CHAT(TIME, TEXT, ID_1_USER, ID_2_USER) VALUES (?,?,?,?)";

        createMessageLocal(message, sql);
    }

    private void createMessageLocal(String message, String sql) {
        Date date = new Date();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, date.getTime());
            preparedStatement.setString(2, message);
            preparedStatement.setInt(3, this.id_user_1);
            preparedStatement.setInt(4,this.id_user_2);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ChatDto> getAllMessage(){
        String sql = "SELECT * FROM CHAT WHERE ID_1_USER = '" + this.id_user_1 + "' AND ID_2_USER = '"+ this.id_user_2 +"' OR  ID_1_USER = '" + this.id_user_2 + "' AND ID_2_USER = '" + this.id_user_1 +"';";

        return getAllMessageLocal(sql);
    }

    public ArrayList<ChatDto> getAllUsersWithMassage(){
        String sql = "SELECT DISTINCT ID_2_USER FROM CHAT WHERE ID_1_USER = '" + this.id_user_1 + "' LIMIT 10;";

        return getAllUsersWithMassageLocal(sql);
    }

    private ArrayList<ChatDto> getAllUsersWithMassageLocal(String sql) {
        try {
            Statement preparedStatement = connection.createStatement();

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            ArrayList<ChatDto> res = new ArrayList<>();
            int id = 0;
            String message = "";
            while (resultSet.next()) {
                id = resultSet.getInt("id_2_user");
                message =  getLastMessage("SELECT TEXT FROM CHAT WHERE ID_2_USER = '"+ id +"';");
                res.add(new ChatDto(giveLogin(id), message));
            }
            return res;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private String getLastMessage(String sql){
        try {
            Statement preparedStatement = connection.createStatement();

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            String res = "";
            while (resultSet.next()) {

                res = resultSet.getString("text");

            }
            return res;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private  ArrayList<ChatDto> getAllMessageLocal(String sql) {
        try {
            Statement preparedStatement = connection.createStatement();

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            ArrayList<ChatDto> res = new ArrayList<>();
            while (resultSet.next()) {

                res.add(new ChatDto(giveLogin(resultSet.getInt("id_1_user")),resultSet.getString("text")));
            }
            return res;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private String giveId(String login) {
        try {
            String sql = "SELECT ID FROM DEFAULT_USER WHERE LOGIN = '" + login + "';";
            Statement preparedStatement = connection.createStatement();

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            String result = "";
            while (resultSet.next()) {
                result += resultSet.getString("ID");
            }
            return result;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return "";
    }
    private String giveLogin(Integer id) {
        try {
            String sql = "SELECT LOGIN FROM DEFAULT_USER WHERE ID = '" + id + "';";
            Statement preparedStatement = connection.createStatement();

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            String result = "";
            while (resultSet.next()) {
                result += resultSet.getString("login");
            }
            return result;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return "";
    }
}
