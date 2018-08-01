package com.example.demo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    Connection conn = null;
    DBConnection() {
        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/proc_test?" +
                            "user=root&password=igdefault");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public Connection getConn() {
        return conn;
    }
}
