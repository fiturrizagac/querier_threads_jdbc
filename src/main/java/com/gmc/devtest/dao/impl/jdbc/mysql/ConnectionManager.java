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
package com.gmc.devtest.dao.impl.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.gmc.devtest.properties.AppProperties;
import static com.gmc.devtest.properties.AppProperties.KeyProperty.USER;
import static com.gmc.devtest.properties.AppProperties.KeyProperty.PASSWORD;
import static com.gmc.devtest.properties.AppProperties.KeyProperty.URL;



public class ConnectionManager {

    public Connection getConnection(){

        Connection _connection = null;

        Properties properties =  new Properties();
        properties.setProperty(ConnectionProperties.user.name(), AppProperties.getProperty(USER));
        properties.setProperty(ConnectionProperties.password.name(),AppProperties.getProperty(PASSWORD));

        try {
            _connection = DriverManager.getConnection(AppProperties.getProperty(URL),properties);

            System.out.println("open connection!!!");

        }catch (SQLException e){

        }
        return _connection;
    }

    public enum ConnectionProperties{
        user,
        password;
    }

}
