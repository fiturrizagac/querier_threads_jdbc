/**
 * $Id$
 *
 * @author francoiturrizaga
 * @date 25/01/16 09:15 PM
 * <p/>
 * Copyright (C) 2016 Scytl Secure Electronic Voting SA
 * <p/>
 * All rights reserved.
 */
package com.gmc.devtest;

import com.gmc.devtest.om.dto.ResultsDTO;
import com.gmc.devtest.properties.AppProperties;
import com.gmc.devtest.thread.LauncherQueryThreadsImpl;
import com.gmc.devtest.thread.QueryThreadsLaunchable;
import org.apache.log4j.Logger;

import static com.gmc.devtest.properties.AppProperties.KeyProperty.THREADS_NUMBER;

public class Initializer {

    private static Logger _log = Logger.getLogger(Initializer.class);

    public static void main(String[] args) throws Exception{

        int numberThreads = AppProperties.getPropertyAsInteger(THREADS_NUMBER);

        _log.debug("Starting measurement of response times until " + numberThreads + " threads.");

        ResultsDTO optimalResult =  new ResultsDTO();

        for (int i = 0; i < numberThreads;i++){

            int currentNumberThreads = i+1;

            _log.debug("Launching "+ currentNumberThreads +" Threads.");

            QueryThreadsLaunchable launcher =  new LauncherQueryThreadsImpl();
            launcher.launchQueryThreads(currentNumberThreads);

            _log.debug("Response time of "+ currentNumberThreads +" Threads -> "+launcher.getTotalResponseTime() +" ms.");
            _log.debug("");

            ResultsDTO stageResult = new ResultsDTO(
                    currentNumberThreads,
                    launcher.getTotalResponseTime());

            if(optimalResult.getOptimalCalculate()>stageResult.getOptimalCalculate()){
                optimalResult = stageResult;
            }

        }

        _log.debug("Total response time most optimal is "+optimalResult.getResponseTime() +" ms, with "
                + optimalResult.getNumberOfThreads() + " Threads.");

    }


}
