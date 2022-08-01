package com.imooc.util;

import javax.servlet.http.HttpServletRequest;

//负责处理HTTPServletRequest参数值
public class HttpServletRequestUtil {
    /*从request中根据key值，找到对应键值转换成整型*/
    public static int getInt(HttpServletRequest request,String key){
        try {
            return Integer.decode(request.getParameter(key));
        }catch (Exception e){
            return -1;
        }
    }
    public static long getLong(HttpServletRequest request,String key){
        try {
            return Long.valueOf(request.getParameter(key));
        }catch (Exception e){
            return -1;
        }
    }

    public static double getDouble(HttpServletRequest request,String key){
        try {
            return Double.valueOf(request.getParameter(key));
        }catch (Exception e){
            return -1d;
        }
    }
    public static boolean getBoolean(HttpServletRequest request,String key){
        try {
            return Boolean.valueOf(request.getParameter(key));
        }catch (Exception e){
            return false;
        }
    }
    public static String getString(HttpServletRequest request,String key){
        try {
            String result = request.getParameter(key);
            if (request!=null){
                /*去掉左右两边的空格*/
                result.trim();
            }
            if ("".equals(result)){
                result = null;
            }
            return result;
        }catch (Exception e){
            return null;
        }
    }
}
