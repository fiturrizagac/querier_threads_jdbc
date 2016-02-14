package com.gmc.devtest.dao.factory.impl.mock;

import com.gmc.devtest.dao.SampleDAO;
import com.gmc.devtest.dao.factory.DAOFactory;
import com.gmc.devtest.dao.impl.mock.SampleMockDAOImpl;

/**
 * Created by BRIGETH on 14/02/2016.
 */
public class MockDAOFactoryImpl implements DAOFactory{

    public SampleDAO getSampleDAO() {
        return new SampleMockDAOImpl();
    }
}
