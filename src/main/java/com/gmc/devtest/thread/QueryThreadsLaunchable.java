package com.gmc.devtest.thread;

/**
 * Created by BRIGETH on 16/02/2016.
 */
public interface QueryThreadsLaunchable {

    void launchQueryThreads(int numberOfThreads);

    Long getTotalResponseTime();

}
