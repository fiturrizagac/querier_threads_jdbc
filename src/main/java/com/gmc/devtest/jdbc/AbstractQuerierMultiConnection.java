/**
 * $Id$
 *
 * @author francoiturrizaga
 * @date 25/01/16 12:41 PM
 * <p/>
 * Copyright (C) 2016 Scytl Secure Electronic Voting SA
 * <p/>
 * All rights reserved.
 */
package com.gmc.devtest.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Observable;

public abstract class AbstractQuerierMultiConnection extends Observable implements Queryable, Connectable {

    private Long _queryTime;

    public Connection getConnection() {
        Connection connection =  new ConnectionManager().getConnection();
        return connection;
    }

    public void close(Connection connection) {
        if(connection!=null){
            try {
                connection.close();
                connection = null;
                System.out.printf("close connection!!!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public Long getQueryTime() {
        return _queryTime;
    }

    public void setQueryTime(final Long queryTime) {
        _queryTime = queryTime;
    }
}
