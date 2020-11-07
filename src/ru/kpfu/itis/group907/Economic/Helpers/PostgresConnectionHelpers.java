package kpfu.itis.group907.Economic.Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnectionHelpers {
    private static Connection connection;

    private static final String URL = "jdbc:postgresql://localhost:5432/economic";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "zinnurik123321";
    private static final String DRIVER = "org.postgresql.Driver";

    public static Connection getConnection(){
        if (connection == null){
            try

            {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(
                        URL,
                        USERNAME,
                        PASSWORD
                );
            }
            catch(SQLException |
                    ClassNotFoundException e)

            {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
