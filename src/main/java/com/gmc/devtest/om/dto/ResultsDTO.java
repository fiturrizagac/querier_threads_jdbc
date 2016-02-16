/**
 * $Id$
 *
 * @author francoiturrizaga
 * @date 25/01/16 03:53 PM
 * <p/>
 * Copyright (C) 2016 Scytl Secure Electronic Voting SA
 * <p/>
 * All rights reserved.
 */
package com.gmc.devtest.om.dto;

public class ResultsDTO {

    private int _numberOfThreads;
    private long _responseTime;

    public ResultsDTO(final int numberOfThreads, final long responseTime) {
        _numberOfThreads = numberOfThreads;
        _responseTime = responseTime;
    }

    public ResultsDTO(){}

    public double getOptimalCalculate() {
        return _responseTime!=0?(_responseTime / (double) _numberOfThreads):999999999;
    }

    public int getNumberOfThreads() {
        return _numberOfThreads;
    }

    public void setNumberOfThreads(final int numberOfThreads) {
        _numberOfThreads = numberOfThreads;
    }

    public long getResponseTime() {
        return _responseTime;
    }

    public void setResponseTime(final long responseTime) {
        _responseTime = responseTime;
    }
}
