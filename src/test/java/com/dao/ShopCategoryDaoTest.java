package com.dao;

import com.BaseTest;
import com.imooc.dao.ShopCategoryDao;
import com.imooc.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.ObjectView;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
    private ShopCategoryDao shopCategoryDao;
    @Test
    public void testQueryShopCategory(){
        List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(new ShopCategory());
        assertEquals(12,shopCategoryList.size());
        System.out.println(shopCategoryList.get(0).getShopCategoryName());

        //支持一级Category的返回
        List<ShopCategory> shopCategoryList1 = shopCategoryDao.queryShopCategory(null);
        System.out.println(shopCategoryList1.size());
    }
}
