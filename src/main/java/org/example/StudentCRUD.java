package org.example;

import java.sql.*;


public class StudentCRUD {

    void insertStudent() {

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b6", "GaikwadShreyas", "@shreyas11");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from students");
            System.out.println("Database Connection is Successfully Done");
            System.out.println();


            while (rs.next()) {
                System.out.println(rs.getInt(1) + ": " + rs.getString(2) + ": " + rs.getString(3) + ": " + rs.getString(4));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        StudentCRUD obj = new StudentCRUD();
        obj.insertStudent();
    }
}

