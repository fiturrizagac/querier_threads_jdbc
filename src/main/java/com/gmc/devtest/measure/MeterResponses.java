/**
 * $Id$
 *
 * @author francoiturrizaga
 * @date 25/01/16 09:30 AM
 * <p/>
 * Copyright (C) 2016 Scytl Secure Electronic Voting SA
 * <p/>
 * All rights reserved.
 */
package com.gmc.devtest.measure;

import java.util.Observable;
import java.util.Observer;

import com.gmc.devtest.jdbc.ConnectionManager;
import com.gmc.devtest.thread.QuerierThread;

public class MeterResponses implements Observer {

    private int _numberOfThreads;
    private QuerierThread[] _queriers;
    private long _totalResponseTime;

    public MeterResponses(int threads) {
        _numberOfThreads = threads;
        _queriers = new QuerierThread[threads];
    }

    public Long calculateResponseTime(){
        for (int i=0;i<_numberOfThreads;i++ ){
            _queriers[i] =  new QuerierThread();
            _queriers[i].addObserver(this);
            Thread localThread =  new Thread(_queriers[i],"Thread "+i );
            localThread.start();
            try {
                localThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ConnectionManager.closeConnection();
        return _totalResponseTime;

    }

    public void update(final Observable o, final Object arg) {
        synchronized (this){
            if(o instanceof QuerierThread){
                QuerierThread qt = (QuerierThread)o;
                _totalResponseTime+=qt.getQueryTime();
            }
        }
    }

}
