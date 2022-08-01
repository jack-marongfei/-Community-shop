package com.imooc.entity;

import com.imooc.entity.PersonInfo;
import com.imooc.entity.Product;
import com.imooc.entity.Shop;

import java.util.Date;

//顾客消费的商品映射
public class UserProductMap {
	// 主键Id
	private Long userProductId;
	// 创建时间
	private Date createTime;
	// 消费商品所获得的积分
	private Integer point;
	// 顾客信息实体类
	private com.imooc.entity.PersonInfo user;
	// 商品信息实体类
	private com.imooc.entity.Product product;
	// 店铺信息实体类
	private com.imooc.entity.Shop shop;
	// 操作员信息实体类
	private com.imooc.entity.PersonInfo operator;

	public Long getUserProductId() {
		return userProductId;
	}

	public void setUserProductId(Long userProductId) {
		this.userProductId = userProductId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public com.imooc.entity.PersonInfo getUser() {
		return user;
	}

	public void setUser(com.imooc.entity.PersonInfo user) {
		this.user = user;
	}

	public com.imooc.entity.Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public com.imooc.entity.Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public com.imooc.entity.PersonInfo getOperator() {
		return operator;
	}

	public void setOperator(PersonInfo operator) {
		this.operator = operator;
	}

}
