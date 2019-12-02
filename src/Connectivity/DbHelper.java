package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbHelper {

    private String userName="root";
    private String password="864297531";
   // private String dbUrl="jdbc:mysql://localhost:3306/projem_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String dbUrl="jdbc:mysql://localhost:3306/projem_db";
    public Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(dbUrl,userName,password);
    }

    public  void showErrorMessage(SQLException exeption){
        System.out.println("Error : "+ exeption.getMessage());
        System.out.println("Error code : " + exeption.getErrorCode());
    }

}
