package com.service;

import com.BaseTest;
import com.imooc.dto.ImageHolder;
import com.imooc.dto.ShopExecution;
import com.imooc.entity.Area;
import com.imooc.entity.PersonInfo;
import com.imooc.entity.Shop;
import com.imooc.entity.ShopCategory;
import com.imooc.enums.ShopStateEnum;
import com.imooc.exceptions.ShopOperationException;
import com.imooc.service.ShopService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;
    @Test
    public void testGetShopList(){
        Shop shopCondition = new Shop();
        ShopCategory sc = new ShopCategory();
        sc.setShopCategoryId(10L);
        shopCondition.setShopCategory(sc);
        ShopExecution se = shopService.getShopList(shopCondition,5,2);
        System.out.println("店铺列表数为："+se.getShopList().size());
        System.out.println("店铺总数为："+se.getCount());
    }


    @Test
    public void testModifyShop() throws Exception {
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopName("修改后的店铺名称");
        File shopImg = new File("C:/Users/MRF/Desktop/imags/dabai.jpg");
        InputStream is = new FileInputStream(shopImg);
        ImageHolder imageHolder = new ImageHolder("dabai.jpg",is);
        ShopExecution shopExecution = shopService.modifyShop(shop,imageHolder);
        System.out.println("新图片的地址为："+shopExecution.getShop().getShopImg());

    }

    @Test
    public void testAddShop() throws FileNotFoundException {
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
        shop.setShopName("测试的店铺1");
        shop.setShopDesc("test1");
        shop.setShopAddr("test1");
        shop.setPhone("test1");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg = new File("C:/Users/MRF/Desktop/imags/xiaohuangren.jpg");
        InputStream is = new FileInputStream(shopImg);
        ImageHolder imageHolder = new ImageHolder(shopImg.getName(),is);
        ShopExecution se =  shopService.addShop(shop,imageHolder);
        assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
    }
}
