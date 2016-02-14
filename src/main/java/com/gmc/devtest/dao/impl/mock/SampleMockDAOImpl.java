package com.gmc.devtest.dao.impl.mock;

import com.gmc.devtest.dao.SampleDAO;
import com.gmc.devtest.om.entity.SampleEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by BRIGETH on 13/02/2016.
 */
public class SampleMockDAOImpl implements SampleDAO{

    public List<SampleEntity> findAll() {

        List<SampleEntity> list = new ArrayList<SampleEntity>();
        list.add(new SampleEntity("uuid1","Area 1",1L));
        list.add(new SampleEntity("uuid2","Area 2",2L));
        list.add(new SampleEntity("uuid3","Area 3",3L));
        list.add(new SampleEntity("uuid4","Area 4",4L));
        list.add(new SampleEntity("uuid5","Area 5",5L));
        list.add(new SampleEntity("uuid6","Area 6",6L));
        list.add(new SampleEntity("uuid7","Area 7",7L));
        list.add(new SampleEntity("uuid8","Area 8",8L));
        list.add(new SampleEntity("uuid9","Area 9",9L));

        _simulateARandomResponseTime();

        return list;
    }

    private void _simulateARandomResponseTime(){
        Random random = new Random();
        Long randomResponseTime = (long)random.nextInt(100)+100L;
        try {
            Thread.currentThread().sleep(randomResponseTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
