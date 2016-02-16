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

public class LauncherQueryThreadsImpl implements QueryThreadsLaunchable, Observer {

    private long _totalResponseTime;

    //@TODO: shouldn't see implementation behavior
    public ThreadQueryTimeResponseCalculable buildThread() {
        ThreadCalculatorQueryTRImpl thread = new ThreadCalculatorQueryTRImpl();
        thread.addObserver(this);
        return thread;
    }

    public void launchQueryThreads(final int numberOfThreads){
        for (int i=0;i<numberOfThreads;i++ ){
            Thread localThread =  new Thread(buildThread(), "Thread-"+numberOfThreads+"-"+i );
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
            if(o instanceof ThreadQueryTimeResponseCalculable){
                ThreadQueryTimeResponseCalculable thread = (ThreadQueryTimeResponseCalculable)o;
                _totalResponseTime += thread.getQueryResponseTime();
            }
        }
    }

    public Long getTotalResponseTime() {
        return _totalResponseTime;
    }
}
