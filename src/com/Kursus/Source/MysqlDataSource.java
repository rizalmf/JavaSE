/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Kursus.Source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ngarambes
 */
public class MysqlDataSource {
    private Connection connection;
    private String user;
    private String password;
    private String server;
    private String database;
    private int portNumber;

    /**
     * @return the connection
     */
    
    public MysqlDataSource(){
        
    }
    public MysqlDataSource(String server, int portNumber, String database, String user, String password){
        this.server = server;
        this.portNumber = portNumber;
        this.database = database;
        this.user = user;
        this.password = password;
    }
    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param server the server to set
     */
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * @param database the database to set
     */
    public void setDatabase(String database) {
        this.database = database;
    }

    /**
     * @param portNumber the portNumber to set
     */
    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }
    
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://"+server+":"+portNumber+"/"+database, user, password);
        return connection;
    }
    
}
