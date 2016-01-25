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
import java.util.Observable;

import com.gmc.devtest.jdbc.ConnectionManager;

public class QuerierThread extends Observable implements Queryable,Runnable {

    private static final String QUERY = "SELECT *  FROM TempCandidate LIMIT 0,10";

    private Long _queryTime;

    public void doQuery(){

        long startQueryTime, endQueryTime;

        Statement statement=null;
        ResultSet resultSet=null;

        try {

            startQueryTime = System.currentTimeMillis();

            statement = getConnection().createStatement();
            resultSet = statement.executeQuery(QUERY);
            Object[] results = new Object[10];
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

            _queryTime = endQueryTime - startQueryTime;

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
        }

    }

    public Long getQueryTime() {
        return _queryTime;
    }

    public void run() {
        doQuery();
        setChanged();
        notifyObservers();

        System.out.println("Finalizó el hilo: " + Thread.currentThread().getName() +", con tiempo de respuesta : "+_queryTime+" ms" );
    }

    private Connection getConnection(){
        return ConnectionManager.getConnection();
    }

}
