package com.imooc.util;


import org.junit.Test;

public class PathUtil {
    private static String seperator = System.getProperty("file.separator");
    /*返回项目图片保存的根路径，随着执行环境的变化而变化的*/
    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath = "";
        if(os.toLowerCase().startsWith("win")){
            basePath = "C:/Users/MRF/Desktop/imags/";
        }else {
            basePath = "/home/xiangze/image/";
        }
        /*斜杠替换*/
        basePath = basePath.replace("/",seperator);
        return basePath;
    }
    /*依据不同的业务需求返回项目的子路径*/
    public static String getShopImagePath(long shopId){
        String imagePath = "upload/item/shop/"+shopId+"/";
        return imagePath.replace("/",seperator);
    }
}
