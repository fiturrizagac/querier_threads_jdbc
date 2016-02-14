package com.gmc.devtest.service;

import com.gmc.devtest.dao.factory.DAOFactory;
import com.gmc.devtest.dao.factory.impl.mock.MockDAOFactoryImpl;

/**
 * Created by BRIGETH on 14/02/2016.
 */
public abstract class AbstractService {

    private DAOFactory _daoFactory;

    public DAOFactory getDaoFactory() {
        if(_daoFactory == null){
            // @TODO: load implementation from properties
            _daoFactory = new MockDAOFactoryImpl();
        }
        return _daoFactory;
    }

    protected abstract <D> D getDAO();

}
