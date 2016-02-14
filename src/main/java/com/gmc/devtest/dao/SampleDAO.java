package com.gmc.devtest.dao;

import com.gmc.devtest.om.entity.SampleEntity;

import java.util.List;

/**
 * Created by BRIGETH on 13/02/2016.
 */
public interface SampleDAO {

    List<SampleEntity> findAll();

}
