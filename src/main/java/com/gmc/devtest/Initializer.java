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

import com.gmc.devtest.dto.ResultDTO;
import com.gmc.devtest.properties.AppProperties;
import com.gmc.devtest.thread.LauncherQueries;

import static com.gmc.devtest.properties.AppProperties.KeyProperty.THREADS_NUMBER;

public class Initializer {

    public static void main(String[] args) throws Exception{

        AppProperties.load();

        int quantity = AppProperties.getPropertyAsInteger(THREADS_NUMBER);

        ResultDTO optimalResult =  new ResultDTO(999999999999999999l);

        for (int i = 0; i < quantity;i++){

            System.out.println("Escenario "+i +": "+(i+1)+" Threads.");

            LauncherQueries launcherQueries =  new LauncherQueries((i+1));
            launcherQueries.launchQueries();

            System.out.println("Tiempo de respuesta por "+launcherQueries.getNumberOfThreads()+" conexiones: " + launcherQueries.getTotalResponseTime() + " ms.");
            System.out.println();


            ResultDTO stageResult = new ResultDTO(
                    "Escenario "+i,
                    launcherQueries.getTotalResponseTime()/(double)launcherQueries.getNumberOfThreads(),
                    launcherQueries.getNumberOfThreads(),
                    launcherQueries.getTotalResponseTime());

            if(optimalResult.getOptimalCalculate()>stageResult.getOptimalCalculate()){
                optimalResult = stageResult;
            }

        }

        System.out.printf("El escenario más optimo es el "+optimalResult.getStage()+"-> N° de Threads : "+ optimalResult.getNumberOfThreads()
                + ", y tiempo: "+optimalResult.getResponseTime()+" ms" );


    }


}
