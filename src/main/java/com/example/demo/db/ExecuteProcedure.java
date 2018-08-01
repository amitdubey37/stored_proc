package com.example.demo.db;

import java.io.*;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteProcedure {


    public void executeSelect() throws SQLException {
        DBConnection dbConnection = new DBConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = dbConnection.getConn().createStatement();
            rs = stmt.executeQuery("SELECT * FROM categories");
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("sub_category"));
            }
        }
        finally {
            // release the lock if they're no longer needed
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
    }

    public void createProcedure() throws SQLException, FileNotFoundException {
        String sql = "";
        try {
            BufferedReader reader=new BufferedReader(new FileReader("/Users/amitdubey/poc/intellimeet/StoredProcedures/src/sql/createTables.sql"));

            String line=null;
            while((line=reader.readLine())!=null){
                sql = sql + " "+line;
            }
            System.out.println(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Statement statement = new DBConnection().getConn().createStatement();
        statement.execute(sql);
    }

    public void executeProcedure() throws SQLException {
        CallableStatement cStmt = new DBConnection().getConn().prepareCall("{call createTables()}");
        cStmt.execute();
    }
}
