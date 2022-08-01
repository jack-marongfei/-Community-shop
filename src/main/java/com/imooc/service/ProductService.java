package com.imooc.service;

import com.imooc.dto.ImageHolder;
import com.imooc.dto.ProductExecution;
import com.imooc.entity.Product;
import com.imooc.exceptions.ProductOperationException;

import java.util.List;

public interface ProductService {
    /*查询商品列表并分页，可以输入的条件有：商品名（模糊），商品状态，店铺Id，商品类别*/

    ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);
    /*添加商品信息以及图片处理*/
    ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList)
            throws ProductOperationException;
    /*通过商品Id查询唯一的商品信息*/
    Product getProductById(long productId);
    /*修改商品信息以及图片处理*/
    ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList)
            throws ProductOperationException;

}
