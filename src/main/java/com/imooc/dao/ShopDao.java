package com.imooc.dao;

import com.imooc.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.io.PrintWriter;
import java.util.List;

public interface ShopDao {
    /**
     * 默认 Java 方法输入 /** 回车会自动生成方法注释，并添加方法参数。
     * @param shopCondition
     * @param rowIndex 从第几行开始取
     * @param pageSize  返回的条数
     * @return
     */
    /*分页查询店铺，可输入的条件有：店铺名（模糊），店铺状态，店铺类别，区域Id，owner*/
    List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition,@Param("rowIndex") int rowIndex,@Param("pageSize") int pageSize);
    /*通过shop id查询店铺*/

    /**
     * 返回queryShopList总数
     * @param shopCondition
     * @return
     */
    int queryShopCount(@Param("shopCondition") Shop shopCondition);

    Shop queryByShopId(long shopId);
    /*新增店铺*/
    int insertShop(Shop shop);
    /*更新店铺*/
    int updateShop(Shop shop);
}
