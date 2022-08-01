package com.imooc.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
    public static boolean checkVerifyCode(HttpServletRequest request){//getAttribute(实际的验证码)
        String verifyCodeExpected = (String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        //实际输入的验证码
        String verifyCodeActual = HttpServletRequestUtil.getString(request,"verifyCodeActual");
        if (verifyCodeActual == null||!verifyCodeActual.equals(verifyCodeExpected)){//为空或者两个不相等的话，返回false
            return false;
        }
        return true;
    }
}
