/**
 * $Id$
 *
 * @author francoiturrizaga
 * @date 25/01/16 09:25 AM
 * <p/>
 * Copyright (C) 2016 Scytl Secure Electronic Voting SA
 * <p/>
 * All rights reserved.
 */
package com.gmc.devtest.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionManager {


    private static Connection _connection;

    private String _url;

    private String _password;

    private String _user;

    DriverManager _driverManager;

    public static Connection getConnection(){

        if(_connection == null){
            Properties properties =  new Properties();
            properties.setProperty(ConnectionProperties.user.name(),"DenmarkCandMng");
            properties.setProperty(ConnectionProperties.password.name(),"DenmarkCandMng");
            String url = "jdbc:mysql://localhost:3306/DenmarkCandMng";
            try {
                _connection = DriverManager.getConnection(url,properties);
                System.out.println("open connection!!!");
            }catch (SQLException e){

            }
        }
        return _connection;
    }

    public static synchronized  void closeConnection(){

        if(_connection != null){

            try {
                _connection.close();
                _connection = null;
                System.out.printf("close connection!!!");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }


    enum ConnectionProperties{
        user,
        password;
    }

}
