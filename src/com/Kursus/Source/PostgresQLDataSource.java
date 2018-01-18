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
public class PostgresQLDataSource {
    private Connection connection;
    private String url; // jdbc:postgresql://localhost:5432/database
    private String user;
    private String password;
    
    public PostgresQLDataSource(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
    
}
