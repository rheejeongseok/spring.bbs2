package com.spring.BBS2.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring.BBS2.model.ModelUser;
@Repository("daoUser")
public class DaoUser implements IDaoUser {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(DaoUser.class);
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session; 
    
    @Override
    public int insertUser(ModelUser user) {
        return session.insert("mapper.mysql.mapperUser.insertUser",user);
    }
    
    @Override
    public ModelUser login(String userid, String password) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("userid", userid);
        map.put("password", password);
        return session.selectOne("mapper.mysql.mapperUser.login",map);
    }
    
    @Override
    public int updateUserInfo(ModelUser updateValue, ModelUser searchValue) {
        
        Map<String,ModelUser> map = new HashMap<String,ModelUser>();
        map.put("updateValue", updateValue);
        map.put("searchValue", searchValue);
        
        return session.update("mapper.mysql.mapperUser.updateUserInfo",map);
    }
    
    @Override
    public int updatePasswd(String newPasswd, String currentPasswd,
            String userid) {
        
        Map<String,String> map = new HashMap<String,String>();
        map.put("newPasswd", newPasswd);
        map.put("currentPasswd", currentPasswd);
        map.put("userid", userid);
        
        return session.update("mapper.mysql.mapperUser.updatePasswd",map);
    }
    
    @Override
    public int deleteUser(ModelUser user) {
        
        return session.update("mapper.mysql.mapperUser.deleteUser",user);
    }
    
    @Override
    public ModelUser selectUser(int userno) {
        // TODO Auto-generated method stub
        return session.selectOne("mapper.mysql.mapperUser.selectUser",userno);
    }
    
    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
        // TODO Auto-generated method stub
        return session.selectList("mapper.mysql.mapperUser.selectUserList",user);
    }
    
    @Override
    public int checkuserid(String userid) {
        // TODO Auto-generated method stub
        return session.selectOne("mapper.mysql.mapperUser.checkuserid",userid);
    }

    @Override
    public int loginajax(String userid, String password) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("userid", userid);
        map.put("password", password);
        return session.selectOne("mapper.mysql.mapperUser.loginajax",map);
    }
}
