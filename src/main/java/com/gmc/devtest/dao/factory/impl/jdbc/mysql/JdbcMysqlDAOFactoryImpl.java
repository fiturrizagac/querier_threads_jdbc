package com.gmc.devtest.dao.factory.impl.jdbc.mysql;

import com.gmc.devtest.dao.SampleDAO;
import com.gmc.devtest.dao.factory.DAOFactory;
import com.gmc.devtest.dao.impl.jdbc.mysql.SampleJdbcMysqlDAOImpl;

/**
 * Created by BRIGETH on 14/02/2016.
 */
public class JdbcMysqlDAOFactoryImpl implements DAOFactory {

    public SampleDAO getSampleDAO() {
        return new SampleJdbcMysqlDAOImpl();
    }

}
