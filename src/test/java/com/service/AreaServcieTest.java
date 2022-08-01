package com.service;

import com.BaseTest;
import com.imooc.entity.Area;
import com.imooc.service.AreaService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AreaServcieTest extends BaseTest {
    @Autowired
    private AreaService areaService;
    @Test
    public void testGetAreaList(){
        List<Area> areaList = areaService.getAreaList();
        for (int i = 0; i < areaList.size(); i++) {
            System.out.println(areaList.get(i));
        }
    }
}
