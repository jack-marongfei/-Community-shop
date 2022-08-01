package com.dao;

import com.BaseTest;
import com.imooc.dao.AreaDao;
import com.imooc.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaDaoTest extends BaseTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQUERYArea(){
        List<Area> areaList = areaDao.queryArea();
        assertEquals(3,areaList.size());

    }
}
