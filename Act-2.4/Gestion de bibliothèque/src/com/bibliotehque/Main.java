package com.bibliotehque;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection con = ConnectionManager.getConnection();
        if (con == null) {
            System.out.println("Connection not found");
        } else {
            System.out.println("Connected successfully");
        }

       /*try {
            Statement stmt = con.createStatement();
            //ResultSet res = stmt.executeQuery("CREATE DATABASE db_bibliotheque");
            ResultSet res = stmt.executeQuery("CREATE TABLE fffff(id int)");
            //étape 4: exécuter la requête
            while(res.next())
                System.out.println(res.getInt(1)+"  "+res.getString(2)
                        +"  "+res.getString(3));
            //étape 5: fermez l'objet de connexion
            con.close();
        } catch (SQLException e) {
            //traitement de l'exception
        }*/
    }
}
