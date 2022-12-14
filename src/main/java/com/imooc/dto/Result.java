package com.imooc.dto;

import org.hamcrest.core.Is;

public class Result<T> {    //泛型类
    private boolean success;//是否是成功的标志
    private T data;         //成功时返回的数据
    private String errorMsg;//错误信息
    private int errorCode;  //状态码
    public Result(){

    }
    //成功时的构造器
    public Result(boolean success,T data){
        this.success = success;
        this.data = data;
    }
    //错误时的构造器
    public Result(boolean success,int errorCode,String errorMsg){
        this.success = success;
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
