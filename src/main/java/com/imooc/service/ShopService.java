package com.imooc.service;
import com.imooc.dto.ImageHolder;
import com.imooc.dto.ShopExecution;
import com.imooc.entity.Shop;
import com.imooc.exceptions.ShopOperationException;
import java.io.File;
import java.io.InputStream;

public interface ShopService {

    ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);

    ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;

    /*通过店铺ID获取店铺信息*/
    Shop getByShopId(long shopId);
    /*更新店铺信息，包括对图片的处理*/

    ShopExecution modifyShop(Shop shop,ImageHolder thumbnail) throws Exception;

}
