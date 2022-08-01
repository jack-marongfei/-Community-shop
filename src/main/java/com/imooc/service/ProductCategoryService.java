package com.imooc.service;

import com.imooc.dto.ProductCategoryExecution;
import com.imooc.entity.ProductCategory;
import com.imooc.exceptions.ProductCategoryOperationException;

import java.util.List;

public interface ProductCategoryService {
    /**
     * 查询指定某个店铺下的所有商品类别信息
     * @param shopId
     * @return
     */
    List<ProductCategory> getProductCategoryList(long shopId);
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
            throws ProductCategoryOperationException;
    ProductCategoryExecution deleteProductCategory(long productCategoryId,long shopId)
        throws ProductCategoryOperationException;
}
