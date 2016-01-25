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

import java.util.Arrays;

import com.gmc.devtest.measure.MeterResponses;

public class Launcher {

    public static void main(String[] args) {

        int quantity = 20;

        Object[] results = new Object[quantity];
        Double[] measures = new Double[quantity];

        Object[] min = new Object[]{0,0,999999999};

        for (int i = 0; i < quantity;i++){

            MeterResponses meter =  new MeterResponses((i+1));
            long time = meter.calculateResponseTime();
            System.out.println("Tiempo de respuesta por "+(i+1)+" conexiones: " + time + " ms.");

            Object[] thread = new Object[]{(i+1),time, time/(double)(i+1)};
            results[i] = thread;

            if(Double.parseDouble(min[2].toString())>Double.parseDouble(thread[2].toString())){
                min = thread;
            }

            measures[i] = time/(double)(i+1);

        }

        System.out.println(Arrays.deepToString(measures));

        System.out.printf("El thread más optimo es: Thread"+ min[0]+ ",con: "+min[1]+" ms" );


    }


}
