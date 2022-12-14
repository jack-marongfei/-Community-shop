package com.imooc.dao;

import com.imooc.entity.LocalAuth;
import org.apache.ibatis.annotations.Param;

import javax.xml.crypto.Data;
import java.util.Date;

public interface LocalAuthDao {
    /**
     * 通过账号和密码查询对应的信息，登录用
     * @param username
     * @param password
     * @return
     */
    LocalAuth queryLocalByUserNameAndPwd(@Param("username") String username,@Param("password") String password);

    /**
     * 通过用户Id查询对应的Localauth
     * @param userId
     * @return
     */
    LocalAuth queryLocalByUserId(@Param("userId") long userId);

    /**
     * 添加平台账号
     * @param localAuth
     * @return
     */
    int insertLocalAuth(LocalAuth localAuth);

    /**
     * 通过userId,username,password更改密码
     * @param userId
     * @param username
     * @param password
     * @param newPassword
     * @param lastEditTime
     * @return
     */
    int updateLocalAuth(@Param("userId")Long userId, @Param("username") String username,
                        @Param("password") String password, @Param("newPassword") String newPassword, @Param("lastEditTime") Date lastEditTime);


}
