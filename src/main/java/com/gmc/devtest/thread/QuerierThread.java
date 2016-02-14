/**
 * $Id$
 *
 * @author francoiturrizaga
 * @date 25/01/16 09:27 AM
 * <p/>
 * Copyright (C) 2016 Scytl Secure Electronic Voting SA
 * <p/>
 * All rights reserved.
 */
package com.gmc.devtest.thread;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gmc.devtest.dao.impl.jdbc.mysql.AbstractQuerierMultiConnection;

public class QuerierThread extends AbstractQuerierMultiConnection implements Runnable {

    private static final String QUERY = "SELECT *  FROM SampleTable";

    public void calculateQueryTime(){

        long startQueryTime, endQueryTime;

        Statement statement=null;
        ResultSet resultSet=null;
        Connection conn =null;

//        ConnectionManager connectionManager = new ConnectionManager();

        try {

            startQueryTime = System.currentTimeMillis();

            conn =  getConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(QUERY);
            Object[] results = new Object[100];
            int i = 0;
            while (resultSet.next()){

                Object[] row = new Object[6];
                row[0] = resultSet.getInt(1);
                row[1] = resultSet.getString(2);
                row[2] = resultSet.getString(3);
                row[3] = resultSet.getString(4);
                row[4] = resultSet.getString(5);
                row[5] = resultSet.getString(6);

                results[i] = row;
                i++;
//                System.out.println(" Row -> " + Arrays.deepToString(row)) ;

            }

            System.out.println(Thread.currentThread().getName()+" -> " + i + " rows");

            endQueryTime = System.currentTimeMillis();

            setQueryTime(endQueryTime - startQueryTime);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            close(conn);

        }

    }

    public void run() {

        calculateQueryTime();
        setChanged();
        notifyObservers();

        System.out.println("Finalizó el Thread: " + Thread.currentThread().getName() +", con tiempo de respuesta : "+ getTotalQueryTime()+" ms" );

    }

}
