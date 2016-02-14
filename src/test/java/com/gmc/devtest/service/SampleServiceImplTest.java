package com.gmc.devtest.service;

import com.gmc.devtest.service.impl.SampleServiceImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by BRIGETH on 14/02/2016.
 */
public class SampleServiceImplTest{

    private SampleServiceImpl _target;

    @Before
    public void setUp(){
        _target = new SampleServiceImpl();
    }

    @Test
    public void calculateResponseTimeFromFindAllOK(){

        System.out.println("RS -> " + _target.calculateResponseTimeFromFindAll() +" ms");
        System.out.println("RS -> " + _target.calculateResponseTimeFromFindAll() +" ms");
        System.out.println("RS -> " + _target.calculateResponseTimeFromFindAll() +" ms");
        System.out.println("RS -> " + _target.calculateResponseTimeFromFindAll() +" ms");
        System.out.println("RS -> " + _target.calculateResponseTimeFromFindAll() +" ms");
        System.out.println("RS -> " + _target.calculateResponseTimeFromFindAll() +" ms");

    }



}
