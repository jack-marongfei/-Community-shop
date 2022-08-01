package com.dao;

import com.BaseTest;
import com.imooc.dao.ProductCategoryDao;
import com.imooc.entity.ProductCategory;
import com.imooc.service.ProductCategoryService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)/*按照名字的顺序升序去执行*/
public class ProductCategoryTest extends BaseTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void testBQueryByShopId() throws Exception{
        long shopId = 1;
        List<ProductCategory> productCategories = productCategoryDao.queryProductCategoryList(shopId);
        System.out.println("该店铺的自定义类别数为："+productCategories.size());
    }
    @Test
    public void testAInsertproductCategory(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryName("商品类别1");
        productCategory.setPriority(1);
        productCategory.setCreateTime(new Date());
        productCategory.setShopId(1L);
        ProductCategory productCategory2 = new ProductCategory();
        productCategory2.setProductCategoryName("商品类别2");
        productCategory2.setPriority(1);
        productCategory2.setCreateTime(new Date());
        productCategory2.setShopId(1L);
        List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
        productCategoryList.add(productCategory2);
        int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
        assertEquals(1,effectedNum);
    }
    @Test
    public void testCDeleteProductCategory() throws Exception{
        long shopId = 1;
        List<ProductCategory> productCategoryList =productCategoryDao.queryProductCategoryList(shopId);
        for (ProductCategory pc:productCategoryList){
            if ("商品类别1".equals(pc.getProductCategoryName())||"商品类别2".equals(pc.getProductCategoryName())){
                int effectedNum = productCategoryDao.deleteProductCategory(pc.getProductCategoryId(),shopId);
                assertEquals(1,effectedNum);
            }
        }
    }
}
