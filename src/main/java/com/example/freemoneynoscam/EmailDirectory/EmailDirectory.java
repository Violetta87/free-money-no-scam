package com.example.freemoneynoscam.EmailDirectory;

import com.example.freemoneynoscam.Model.Email;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EmailDirectory {

        private Statement stmt;
        private ResultSet rs;
        private String sqlString;
        private Connection con;

        public void connectDB() {
            try {
                String url = "jdbc:mysql://localhost:3306/get_money_no_scam";
                con = DriverManager.getConnection(url, "root", "Password");
                System.out.println("Ok, we have a connection.");
            } catch (Exception var1) {
                var1.printStackTrace();
            }
        }


        public void makeTableEmail(String email) {
            String sqlString = "INSERT INTO email (`email`)" + "VALUES('" +email+"');";
            try {
                stmt = con.createStatement();
                stmt.executeUpdate(sqlString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public ArrayList<Email> getEMailsFromDatabase() {

            connectDB();
            ArrayList<Email> list = new ArrayList<>();
            {
                try {
                    sqlString = "SELECT * FROM `email`";
                    stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                    rs = stmt.executeQuery(sqlString);

                    while (rs.next()) {
                        list.add(new Email(rs.getString("email")));

                        System.out.println(list);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return list;

            }


        }
}
