package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDB {

    /* Database connection settings, change dbName, dbusername, dbpassword */
    private final String ipAddress = "localhost";
    private final String dbServerPort = "3306";
    private final String dbName = "your-db-name";
    private final String dbusername = "your-db-username";
    private final String dbpassword = "your-db-password";


    private Connection con = null;

    /**
     * Establishes a connection with the database, initializes and returns
     * the Connection object.
     *
     * @return Connection, the Connection object
     * @throws Exception
     */
    public Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://"
                    + ipAddress + ":" + dbServerPort + "/" + dbName, dbusername, dbpassword);
            return con;
        } catch (Exception e) {

            throw new Exception("Could not establish connection with the Database Server: "
                    + e.getMessage());
        }

    }

    /**
     * Close database connection. It is very important to close the database connection
     * after it is used.
     *
     * @throws SQLException
     */
    public void close() throws SQLException {
        try {
            if (con != null)
                con.close();
        } catch (SQLException e) {
            throw new SQLException("Could not close connection with the Database Server: "
                    + e.getMessage());
        }

    }
}