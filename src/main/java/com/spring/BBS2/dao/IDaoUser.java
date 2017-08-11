package com.spring.BBS2.dao;

import java.util.List;

import com.spring.BBS2.model.ModelUser;

public interface IDaoUser {
    
    int insertUser(ModelUser user);
    ModelUser login(String userid, String password);
    int updateUserInfo(ModelUser updateValue,ModelUser searchValue);
    int updatePasswd(String newPasswd,String currentPasswd,String userid);
    int deleteUser(ModelUser user);
    ModelUser selectUser(int userno);
    List<ModelUser> selectUserList(ModelUser user);
    int checkuserid(String userid);
    int loginajax(String userid, String password);
    
}
