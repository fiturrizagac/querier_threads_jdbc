package com.gmc.devtest.service.impl;

import com.gmc.devtest.dao.SampleDAO;
import com.gmc.devtest.service.AbstractService;
import com.gmc.devtest.service.SampleService;

/**
 * Created by BRIGETH on 14/02/2016.
 */
public class SampleServiceImpl extends AbstractService implements SampleService{

    @Override
    protected SampleDAO getDAO() {
        return getDaoFactory().getSampleDAO();
    }

    public Long calculateResponseTimeFromFindAll() {

        Long endQueryTime, startQueryTime;

        startQueryTime  = System.currentTimeMillis();
        getDAO().findAll();
        endQueryTime =  System.currentTimeMillis();

        return endQueryTime - startQueryTime;
    }
}
