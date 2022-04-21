package com.bibliotehque;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager { //Il en va de soit que plus tard cette méthode sera améliorée.
    private static String driverName = "org.postgresql.Driver";
    private static String username = "postgres";
    private static String password = "postgres";
    private static Connection con;
    private static String urlstring ="jdbc:postgresql://localhost:5432/db_medsaddem";

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(urlstring, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found.");
        }
        return con;
    }
}
