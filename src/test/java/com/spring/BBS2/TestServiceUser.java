package com.spring.BBS2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.BBS2.model.ModelArticle;
import com.spring.BBS2.model.ModelComments;
import com.spring.BBS2.model.ModelUser;
import com.spring.BBS2.service.IServiceBoard;
import com.spring.BBS2.service.IServiceUser;

public class TestServiceUser {
    // SLF4J Logging
    private static Logger logger = LoggerFactory
            .getLogger(TestServiceUser.class);

    private static ApplicationContext context = null;
    private static IServiceUser svruser  = null;
    private static IServiceBoard svrboard = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        svruser   = context.getBean("serviceUser", IServiceUser.class);
        svrboard   = context.getBean("serviceboard", IServiceBoard.class);
    }
    
    @Test
    public void testinsertUser() {
        
        ModelUser user = new ModelUser(); 
        user.setUserid("rheejs");
        user.setEmail("aa@aa.co.kr");
        user.setPassword("1234");
        user.setUsername("정석쨩");
        user.setPhone("123123123");
        
        int result = 0;
        result = svruser.insertUser(user);
        
        assertEquals(result, 1);
        
        
    }
    
    @Test
    public void testLogin(){
        
        ModelUser result = null;
        
        ModelUser user = new ModelUser();
        user.setUserid("rheejs");
        user.setPassword("1234");
        result = svruser.login(user.getUserid(),user.getPassword());
        
        assertEquals(result.getUserid(), "rheejs");
        
    }
    
    @Test
    public void testUpdateUserInfo(){
        
        int result = 0;
        
        ModelUser updateValue = new ModelUser();
        updateValue.setEmail("bb@bb.co.kr");
        updateValue.setPassword("4321");
        updateValue.setUsername("석정");
        updateValue.setPhone("321321321");
        ModelUser searchValue = new ModelUser();
        searchValue.setUserid("rheejs");
        searchValue.setEmail("aa@aa.co.kr");
        
        result = svruser.updateUserInfo(updateValue, searchValue);
        assertEquals(result, 1);
    }
    
    @Test
    public void testupdatePasswd(){
        
       int result = 0;
       
       ModelUser user = new ModelUser();
       
       String newPasswd = "aaa";
       String currentPasswd = "4321";
       String userid = "rheeJS";
       
       result = svruser.updatePasswd(newPasswd, currentPasswd, userid);
       
       assertEquals(result, 1);
        
    }
    
    @Test
    public void testdeleteUser(){
        
      ModelUser user = new ModelUser();
      int result = 0;
      
      user.setUserid("rheejs");
      
      result = svruser.deleteUser(user);
      
      assertEquals(result, 1);
        
    }
    
    @Test
    public void testselectUser(){

      ModelUser result = null;

      result = svruser.selectUser(1);
      
      assertEquals(result.getUsername(), "석정");
        
    }
    
    @Test
    public void testselectUserList(){
        
      ModelUser user = new ModelUser();
      List<ModelUser> result = null;
      
      user.setUserid("rheejs");
      
      result = svruser.selectUserList(user);
      
      assertEquals(result.size(), 1);
      
        
    }
    
    @Test
    public void testcheckuserid(){
        
      int result = 0;
      String userid = "rheeJS";
      
      result = svruser.checkuserid(userid);
      
      assertEquals(result, 1);
        
    }
    
    @Test
    public void testinsertarticle(){
     
        ModelArticle article = new ModelArticle();
        article.setBoardcd("free");
        article.setUserid("rhee");
        article.setTitle("asdfasdfasf");
        
        int result = -1;
        result = svrboard.insertArticle(article);
        assertEquals(result, 1);
        
    }
    
    @Test
    public void testgetCommentNo(){
        
        ModelComments comments = new ModelComments();
        comments.setUserid("rhee");
        comments.setMemo("aaa");
        
        int result = 0;
        result = svrboard.getCommentNo(comments);
        
        assertEquals(result, 3);
        
    }
    
}
