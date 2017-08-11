package com.spring.BBS2.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.BBS2.dao.IDaoUser;
import com.spring.BBS2.model.ModelUser;

@Service("serviceUser")
public class ServiceUser implements IServiceUser {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceUser.class);
    
    @Autowired
    @Qualifier("daoUser")
    private IDaoUser daouser;
    
    @Override
    public int insertUser(ModelUser user) {
        
        int result = 0; 
        try {
            result = daouser.insertUser(user);
        } catch (Exception e) {

            logger.error("insertUser" + e.getMessage() );
            throw e;
        }

        return result;
    }
    
    @Override
    public ModelUser login(String userid, String password) {
        
        ModelUser result = null;
        try {
            result = daouser.login(userid,password);
        } catch (Exception e) {
            logger.error("login" + e.getMessage() );
            throw e;
        }
        
        return result;
    }
    
    @Override
    public int updateUserInfo(ModelUser updateValue, ModelUser searchValue) {
        
        int result = 0;
        try {
            result = daouser.updateUserInfo(updateValue, searchValue);
        } catch (Exception e) {
            logger.error("updateUserInfo" + e.getMessage() );
            throw e;
        }
        
        return result;
    }
    
    @Override
    public int updatePasswd(String newPasswd, String currentPasswd,
            String userid) {
        int result = 0;
        try {
            result = daouser.updatePasswd(newPasswd, currentPasswd, userid);
        } catch (Exception e) {
            logger.error("updatePasswd" + e.getMessage() );
            throw e;
        }
        return result;
    }
    
    @Override
    public int deleteUser(ModelUser user) {
        
        int result = 0;
        try {
            result = daouser.deleteUser(user);
        } catch (Exception e) {
            logger.error("deleteUser" + e.getMessage() );
            throw e;
        }
        
        return result;
    }
    
    @Override
    public ModelUser selectUser(int userno) {
        
        ModelUser result = null;
        try {
            result = daouser.selectUser(userno);
        } catch (Exception e) {
            logger.error("selectUser" + e.getMessage() );
            throw e;
        }
        return result;
    }
    
    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
        
        List<ModelUser> result = null;
        try {
            result = daouser.selectUserList(user);
        } catch (Exception e) {
            logger.error("selectUserList" + e.getMessage() );
            throw e;
        }
        
        return result;
    }
    
    @Override
    public int checkuserid(String userid) {
        
        int result = 0;
        try {
            result = daouser.checkuserid(userid);
        } catch (Exception e) {
            logger.error("checkuserid" + e.getMessage() );
            throw e;
        }
        return result;
    }

    @Override
    public int loginajax(String userid, String password) {
        // TODO Auto-generated method stub
        int result = 0;
        try {
            result = daouser.loginajax(userid,password);
        } catch (Exception e) {
            logger.error("loginajax" + e.getMessage() );
            throw e;
        }
        return result;
    }

}
