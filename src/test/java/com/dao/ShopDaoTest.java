package com.dao;


import com.BaseTest;
import com.imooc.dao.ShopDao;
import com.imooc.dto.ShopExecution;
import com.imooc.entity.Area;
import com.imooc.entity.PersonInfo;
import com.imooc.entity.Shop;
import com.imooc.entity.ShopCategory;
import com.imooc.service.ShopService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    public void testQueryShopList_AND_shopCount(){
        Shop shopCondition = new Shop();
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1L);
        shopCondition.setOwner(owner);
        List<Shop> shopList = shopDao.queryShopList(shopCondition,0,5);
        int count = shopDao.queryShopCount(shopCondition);
        System.out.println("店铺列表的大小：" + shopList.size());
        System.out.println("店铺总数：" + count);
        ShopCategory sc = new ShopCategory();
        sc.setShopCategoryId(10L);
        shopCondition.setShopCategory(sc);
        shopList = shopDao.queryShopList(shopCondition,0,2);
        System.out.println("xin店铺列表大小："+shopList.size());
        count = shopDao.queryShopCount(shopCondition);
        System.out.println("xin店铺总数："+ count);


    }




    @Test
    public void testQueryByShopId(){
        long shopId = 39;
        Shop shop = shopDao.queryByShopId(shopId);
        System.out.println(shop.getArea().getAreaId());
        System.out.println(shop.getArea().getAreaName());
    }

    @Test
    public void testInsertShop() {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1l);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(10l);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int effectedNum = shopDao.insertShop(shop);
        Assert.assertEquals(1,effectedNum);
    }

    @Test
    public void testUpdate() {
        Shop shop = new Shop();
        shop.setShopId(39l);
        shop.setShopDesc("测试描述");
        shop.setShopAddr("测试地址");
        int effectedNum = shopDao.updateShop(shop);
        Assert.assertEquals(1,effectedNum);
    }

}
