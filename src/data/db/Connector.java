package data.db;

import java.sql.*;

/**
 * Created by cesar on 03/09/16.
 */
public class Connector {
    private static String DB_NAME = "laundrysys";
    private static String URL = "jdbc:mysql://localhost:3306/"+ DB_NAME;
    private static String USERNAME = "root";
    private static String PASSWORD = "juancmonhey";
    private Connection conn = null;

    public Connector(){
        System.out.println("Connecting database...");
        try {
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return conn;
    }

    public int executeStatement(String stmts){
        Statement stmt = null;
        int stat;
        try {
            stmt = conn.createStatement();
            stat = stmt.executeUpdate(stmts);
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            stat = -1;
        }
        return stat;
    }

    public ResultSet executeQuery(String query){
        Statement stmt = null;
        ResultSet rs;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            rs = null;
        }
        return rs;
    }
}
