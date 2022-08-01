package com.imooc.exceptions;
//业务异常类，是对RuntimeException做的一点小小的封装，让其明白异常是与店铺操作相关的
public class ShopOperationException extends RuntimeException{
    public ShopOperationException(String msg){
        super(msg);
    }

}
