package com.imooc.dao;

import com.imooc.entity.Area;

import java.util.List;

public interface AreaDao {
    /*列出区域列表,mybatis不需要dao实现类*/
    List<Area> queryArea();
}
