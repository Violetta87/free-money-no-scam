package Emailrepository;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Mysql {
    private Statement stmt;
    private ResultSet rs;
    private String sqlString;
    private Connection con;

    public void connectDB() {
        try {
            String url = "jdbc:mysql://localhost:3306/get_money_no_scam";
            con = DriverManager.getConnection(url, "root", "Allalu87");
            System.out.println("Ok, we have a connection.");
        } catch (Exception var1) {
            var1.printStackTrace();
        }
}


    public void makeTableMovie(String email) {
    String sqlString = "INSERT INTO email (`email`)" + "VALUES('" +email+"');";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(sqlString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

