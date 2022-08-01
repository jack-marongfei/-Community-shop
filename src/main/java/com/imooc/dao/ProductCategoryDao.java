package com.imooc.dao;

import com.imooc.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface ProductCategoryDao {
    /**
     * 通过shop id查询所有店铺下的商品类别，并且存储在一个列表中并且将其返回给前台
     * @param shopId
     * @return
     */
    List<ProductCategory> queryProductCategoryList(long shopId);
    /**
     * 批量新增商品
     * @param productCategoryList
     * @return
     */
    int batchInsertProductCategory(List<ProductCategory> productCategoryList);
    /**
     * 删除指定商品类别
     * @param productCategoryId
     * @param shopId
     * @return
     */
    int deleteProductCategory(@Param("productCategoryId") long productCategoryId,@Param("shopId") long shopId );
}
