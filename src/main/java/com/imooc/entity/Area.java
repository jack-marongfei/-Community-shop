package com.imooc.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Area {//类型都是引用类型，如果是基础类的话，那么就会有默认值，对与属性空就是空
    //ID
    public Integer areaId;
    //名称
    private String areaName;
    //权重(排名越大越靠前)
    private Integer priority;
    //createTime
    private Date creatTime;
    //更新时间
    private Date lastEditTime;


    public Area() {
    }

    public Area(Integer areaId, String areaName, Integer priority, Date creatTime, Date lastEditTime) {
        this.areaId = areaId;
        this.areaName = areaName;
        this.priority = priority;
        this.creatTime = creatTime;
        this.lastEditTime = lastEditTime;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", priority=" + priority +
                ", creatTime=" + creatTime +
                ", lastEditTime=" + lastEditTime +
                '}';
    }
}
