package kpfu.itis.group907.Economic.Dao.Impl;

import kpfu.itis.group907.Economic.Dao.DefaultUserDao;
import kpfu.itis.group907.Economic.Helpers.PostgresConnectionHelpers;
import kpfu.itis.group907.Economic.Models.DefaultUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DiagramDao {
    private final Connection connection = PostgresConnectionHelpers.getConnection();
    private String idUser;
    private String login;

    public DiagramDao(String login){
        this.idUser = giveId(login);
        this.login = login;
    }

    public HashMap<String, Integer> getAll(){
        String sql = "SELECT * FROM DEFAULT_USER_DIAGRAM WHERE ID_DEFAULT_USER = '" + this.idUser + "';";

        return getAllLocal(sql);
    }

    public HashMap<String, Integer> getOne(String name_category){
        String sql = "SELECT * FROM DEFAULT_USER_DIAGRAM WHERE ID_DEFAULT_USER = '" + this.idUser + "'AND CATEGORY LIKE '" + name_category + "%' LIMIT 1;";

        return getAllLocal(sql);
    }


    public void remove(String name_category){
        String sql = "DELETE FROM DEFAULT_USER_DIAGRAM WHERE CATEGORY = '" + name_category +"' AND ID_DEFAULT_USER='" + this.idUser + "';";
        System.out.println(sql);
        removeLocal(sql);
    }

    private void removeLocal(String sql) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean save(String nameCategory, Integer count)   {
        String sql = "SELECT * FROM DEFAULT_USER_DIAGRAM WHERE ID_DEFAULT_USER = '" + this.idUser + "';";
        int free = countFree(sql);
//        System.out.println(free + " " + giveId(login));
        if (free <= 20 && checkName(nameCategory, sql)) {

            sql = "INSERT INTO DEFAULT_USER_DIAGRAM (CATEGORY, COUNT_CATEGORY, ID_DEFAULT_USER) VALUES (?, ?, ?)";
            saveLocal(nameCategory, count, sql, giveId(this.login));

            return true;

        } else {
            return false;
        }

    }



    public boolean changeCategory(String newNameCategory, String originalCategories){
        String sql = "SELECT * FROM DEFAULT_USER_DIAGRAM WHERE ID_DEFAULT_USER = '" + this.idUser + "';";
        boolean b = false;

        try {
            Statement createStatement = connection.createStatement();

            ResultSet resultSet = createStatement.executeQuery(sql);
            for (int i = 0; resultSet.next(); i++) {
                String sqlLocal = "UPDATE DEFAULT_USER_DIAGRAM SET category = '" + newNameCategory + "'WHERE ID_DEFAULT_USER =  '" + this.idUser + "' and CATEGORY = '" + originalCategories + "';";
                PreparedStatement preparedStatement = connection.prepareStatement(sqlLocal);
                preparedStatement.executeUpdate();
            }
            b = true;
        }

        catch (SQLException e){
            e.printStackTrace();
        }
        return b;
    }

    public boolean changeCountCategory(String newCountCategories, String originalCategories){
        String sql = "SELECT * FROM DEFAULT_USER_DIAGRAM WHERE ID_DEFAULT_USER = '" + this.idUser + "';";
        boolean b = false;

        try {
            Statement createStatement = connection.createStatement();

            ResultSet resultSet = createStatement.executeQuery(sql);
            System.out.println(Integer.parseInt(newCountCategories));
            for (int i = 0; resultSet.next(); i++) {
                    String sqlLocal = "UPDATE DEFAULT_USER_DIAGRAM SET count_category = '" + Integer.parseInt(newCountCategories) + "'WHERE ID_DEFAULT_USER =  '" + this.idUser + "' and CATEGORY = '" + originalCategories + "';";
                    PreparedStatement preparedStatement = connection.prepareStatement(sqlLocal);
                    preparedStatement.executeUpdate();
            }
            b = true;
        }

        catch (SQLException e){
            e.printStackTrace();
        }
        return b;
    }


    private boolean checkName(String name, String sql){
        try {
            Statement preparedStatement = connection.createStatement();

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            boolean res = true;
            while (resultSet.next()) {
                if(resultSet.getString("CATEGORY").equals(name)){
                    res = false;
                    break;
                }
            }
            return res;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    private HashMap<String, Integer> getAllLocal(String sql) {
        try {
            Statement preparedStatement = connection.createStatement();

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            HashMap<String, Integer> result = new HashMap<>();
            while (resultSet.next()) {
                result.put(resultSet.getString("CATEGORY"), Integer.parseInt(resultSet.getString("COUNT_CATEGORY")));
            }
            return result;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private void saveLocal(String nameCategory, Integer count, String sql, String ID) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nameCategory);
            preparedStatement.setString(2, count + "");
            preparedStatement.setInt(3, Integer.parseInt(ID));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    private Integer countFree(String sql){
        int free = 0;
        try {
            Statement preparedStatement = connection.createStatement();

            ResultSet resultSet = preparedStatement.executeQuery(sql);


            while (resultSet.next()) {
                free++;
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return free;
    }
}


//    public void txt()
//    {
//        String sql = "SELECT * FROM TEXT_S WHERE ID = '" + 1 + "';";
//
//        try {
//            Statement createStatement = connection.createStatement();
//
//            ResultSet resultSet = createStatement.executeQuery(sql);
//            for (int i = 0; resultSet.next(); i++) {
//                System.out.println(resultSet.getString("txt"));
//            }
//        }
//
//        catch (SQLException e){
//            e.printStackTrace();
//        }
//    }