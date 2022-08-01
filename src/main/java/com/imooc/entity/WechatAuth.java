package com.imooc.entity;

import com.imooc.entity.PersonInfo;

import java.util.Date;

public class WechatAuth {
    private Long WechatAuthId;
    private String openId;
    private Date createTime;
    private com.imooc.entity.PersonInfo personInfo;

    public Long getWechatAuthId() {
        return WechatAuthId;
    }

    public void setWechatAuthId(Long wechatAuthId) {
        WechatAuthId = wechatAuthId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public com.imooc.entity.PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
