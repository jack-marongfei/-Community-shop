package com.service;

import com.BaseTest;
import com.imooc.dto.LocalAuthExecution;
import com.imooc.entity.LocalAuth;
import com.imooc.entity.PersonInfo;
import com.imooc.entity.WechatAuth;
import com.imooc.enums.WechatAuthStateEnum;
import com.imooc.service.LocalAuthService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocalAuthServiceTest extends BaseTest  {
    @Autowired
    private LocalAuthService localAuthService;
    @Test
    public void testABindLocalAuth(){
        //新增一条平台账号
        LocalAuth localAuth = new LocalAuth();
        PersonInfo personInfo = new PersonInfo();
        String username = "testusername";
        String password = "testpassword";
        //给平台账号设置上用户信息
        //给用户设置上用户Id，标明是某个用户创建的账号
        personInfo.setUserId(1L);
        //给平台账号设置用户信息，标明是与那个用户绑定
        localAuth.setPersonInfo(personInfo);
        localAuth.setUsername(username);
        localAuth.setPassword(password);
        //绑定账号
        LocalAuthExecution lae = localAuthService.bindLocalAuth(localAuth);
        assertEquals(WechatAuthStateEnum.SUCCESS.getState(),lae.getState());
        //通过UserId找到新增的localAuth
        localAuth = localAuthService.getLocalAuthByUserId(personInfo.getUserId());
        System.out.println("用户昵称："+localAuth.getPersonInfo().getName());
        System.out.println("平台账号密码："+localAuth.getPassword());

    }
    @Test
    public void testBModifyLocalAuth() {
        // 设置帐号信息
        long userId = 1;
        String username = "testusername";
        String password = "testpassword";
        String newPassword = "testnewpassword";
        // 修改该帐号对应的密码
        LocalAuthExecution lae = localAuthService.modifyLocalAuth(userId, username, password, newPassword);
        assertEquals(WechatAuthStateEnum.SUCCESS.getState(), lae.getState());
        // 通过帐号密码找到修改后的localAuth
        LocalAuth localAuth = localAuthService.getLocalAuthByUsernameAndPwd(username, newPassword);
        // 打印用户名字看看跟预期是否相符
        System.out.println(localAuth.getPersonInfo().getName());
    }

}
