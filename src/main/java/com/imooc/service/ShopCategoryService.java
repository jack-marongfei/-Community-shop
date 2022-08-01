package com.imooc.service;

import com.imooc.entity.ShopCategory;

import java.util.List;

public interface ShopCategoryService {
    //根据条件获取查询列表
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);

}
