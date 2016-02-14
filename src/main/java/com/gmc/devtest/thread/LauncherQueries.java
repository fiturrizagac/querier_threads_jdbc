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
package com.gmc.devtest.thread;

import java.util.Observable;
import java.util.Observer;

public class LauncherQueries implements Observer {

    private int _numberOfThreads;
    private CalculatorQueryTRThread[] _queriers;
    private long _totalResponseTime;

    public LauncherQueries(int threads) {
        _numberOfThreads = threads;
        _queriers = new CalculatorQueryTRThread[threads];
    }

    public void launchQueries(){
        for (int i=0;i<_numberOfThreads;i++ ){
            _queriers[i] =  new CalculatorQueryTRThread();
            _queriers[i].addObserver(this);
            Thread localThread =  new Thread(_queriers[i], " Thread "+i );
            localThread.start();
            try {
                localThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(final Observable o, final Object arg) {
        synchronized (this){
            if(o instanceof QueryTimeCalculable){
                QueryTimeCalculable qtc = (QueryTimeCalculable)o;
                _totalResponseTime+=qtc.getTotalQueryTime();
            }
        }
    }

    public int getNumberOfThreads() {
        return _numberOfThreads;
    }

    public long getTotalResponseTime() {
        return _totalResponseTime;
    }
}
