package com.example.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {

    private static Connection cnn;
    private String driver;
    private String urlDriver;
    private String hostName;
    private String port;
    private String databaseName;
    private String userName;
    private String password;

    public Connection getCnn() {
        return cnn;
    }

    public void setCnn(Connection cnn) {
        this.cnn = cnn;
    }

    public DAO() {
        this.driver = "com.mysql.cj.jdbc.Driver";
        this.urlDriver = "jdbc:mysql://";
        this.hostName = "localhost";
        this.port = "3306";
        this.databaseName = "FData";
        this.userName = "root";
        this.password = "";
        this.openConnection();
    }


    public ResultSet executeQuery(String sql) throws SQLException {
        if (cnn == null) {
            openConnection();
        }
        ResultSet rs = null;
        Statement stm = cnn.createStatement();
        rs = stm.executeQuery(sql);
        return rs;
    }

    public int executeUpdateQuery(String sql) {
        if (cnn == null) {
            openConnection();
        }
        int resultCount = 0;
        try {
            Statement stm = cnn.createStatement();
            resultCount = stm.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
        return resultCount;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if (getConnection() == null) {
            System.out.println("connect success");
        }
    }

    public void openConnection() {
        try {
            Class.forName(this.driver);
            cnn = DriverManager.getConnection(this.urlDriver + this.hostName + ":" + this.port + "/" + this.databaseName, this.userName, this.password);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {
        return cnn;
    }

    public void closeConnection() {
        if (cnn != null) {
            try {
                System.out.println("Success");
                cnn.close();
            } catch (SQLException ex) {
            }
        }
    }


    /**
     * @return the urlDriver
     */
    public String getUrlDriver() {
        return urlDriver;
    }

    /**
     * @param urlDriver the urlDriver to set
     */
    public void setUrlDriver(String urlDriver) {
        this.urlDriver = urlDriver;
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * @return the databaseName
     */
    public String getDatabaseName() {
        return databaseName;
    }

    /**
     * @param databaseName the databaseName to set
     */
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the hostName
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * @param hostName the hostName to set
     */
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
}