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

public class ResultDTO {

    private String _stage;
    private double _optimalCalculate;
    private int _numberOfThreads;
    private long _responseTime;

    public ResultDTO(final String stage, final double optimalCalculate, final int numberOfThreads, final long responseTime) {
        _stage = stage;
        _optimalCalculate = optimalCalculate;
        _numberOfThreads = numberOfThreads;
        _responseTime = responseTime;
    }

    public ResultDTO(final double optimalCalculate) {
        _optimalCalculate = optimalCalculate;
    }

    public String getStage() {
        return _stage;
    }

    public void setStage(final String stage) {
        _stage = stage;
    }

    public double getOptimalCalculate() {
        return _optimalCalculate;
    }

    public void setOptimalCalculate(final double optimalCalculate) {
        _optimalCalculate = optimalCalculate;
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
