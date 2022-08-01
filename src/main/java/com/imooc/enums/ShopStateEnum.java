package com.imooc.enums;

public enum ShopStateEnum {
    CHECK(0,"审核中"),OFFLINE(-1,"非法店铺"),SUCCESS(1,"操作成功"),
    PASS(2,"通过认证"),INNER_ERROR(-1001,"内部系统错误"),NULL_SHOPID(-1002,"ShopId为空"),NULL_SHOP(-1003,"shop信息为空");
    private int state;
    private String stateInfo;
//构造器设置为私有的，只能通过内部私有的构造器去创建，将其当成常量来使用
    private ShopStateEnum(int state, String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }
//    依据传入的state返回相应的enum值
    public static ShopStateEnum stateOf(int state){
        for (ShopStateEnum stateEnum:values()) {
            if (stateEnum.getState()==state){
                return stateEnum;
            }
        }
        return null;
    }
//只保留get方法，不希望程序外通过set方法来修改枚举状态的值
    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

}
