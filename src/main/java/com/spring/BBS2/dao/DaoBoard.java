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

import com.spring.BBS2.model.ModelArticle;
import com.spring.BBS2.model.ModelAttachFile;
import com.spring.BBS2.model.ModelBoard;
import com.spring.BBS2.model.ModelComments;


@Repository("daoboard")
public class DaoBoard implements IDaoBoard {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(DaoBoard.class);
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    
    @Override
    public String getBoardName(String boardcd) {
        // TODO Auto-generated method stub
        return session.selectOne("mapper.mysql.mapperBoard.getBoardName",boardcd);
    }
    
    @Override
    public ModelBoard getBoardOne(String boardcd) {
        // TODO Auto-generated method stub
        return session.selectOne("mapper.mysql.mapperBoard.getBoardOne",boardcd);
    }
    
    @Override
    public List<ModelBoard> getBoardList() {
        // TODO Auto-generated method stub
        return session.selectList("mapper.mysql.mapperBoard.getBoardList");
    }
    
    @Override
    public int insertBoard(ModelBoard board) {
        // TODO Auto-generated method stub
        return session.insert("mapper.mysql.mapperBoard.insertBoard",board);
    }
    
    @Override
    public int updateBoard(ModelBoard updateValue, ModelBoard searchValue) {
        // TODO Auto-generated method stub
        Map<String,ModelBoard> map = new HashMap<String,ModelBoard>();
        map.put("updateValue",updateValue);
        map.put("searchValue",searchValue);
        return session.update("mapper.mysql.mapperBoard.updateBoard",map);
    }
    
    @Override
    public int deleteBoard(ModelBoard board) {
        // TODO Auto-generated method stub
        return session.delete("mapper.mysql.mapperBoard.deleteBoard",board);
    }

    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) {
        // TODO Auto-generated method stub
        return session.selectList("mapper.mysql.mapperBoard.getBoardSearch",board);
    }
    
    @Override
    public List<ModelBoard> getBoardPaging(String boardcd, String boardnm,
            String searchWord, Integer start, Integer end) {
        // TODO Auto-generated method stub
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("boardcd", boardcd);
        map.put("boardnm", boardnm);
        map.put("searchWord", searchWord);
        map.put("start", start);
        map.put("end", end);
        return session.selectList("mapper.mysql.mapperBoard.getBoardPaging",map);
    }


    @Override
    public int insertBoardList(List<ModelBoard> list) {
        // TODO Auto-generated method stub
        return session.insert("mapper.mapperBoard.insertBoardList", list);
    }

    @Override
    public int getArticleTotalRecord(String boardcd, String searchWord) {
        // TODO Auto-generated method stub
        Map<String,String> map = new HashMap<String,String>();
        map.put("boardcd", boardcd);
        map.put("searchWord", searchWord);
        return session.selectOne("mapper.mysql.mapperBoard.getArticleTotalRecord",map);
    }

    @Override
    public List<ModelArticle> getArticleList(String boardcd, String searchWord,
            Integer start, Integer end) {
        // TODO Auto-generated method stub
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("boardcd", boardcd);
        map.put("searchWord", searchWord);
        map.put("start", start);
        map.put("end", end);
        
        return session.selectList("mapper.mysql.mapperBoard.getArticleList",map);
    }

    @Override
    public ModelArticle getArticle(int articleNo) {
        // TODO Auto-generated method stub
        return session.selectOne("mapper.mysql.mapperBoard.getArticle",articleNo);
    }

    @Override
    public int insertArticle(ModelArticle article) {
        // TODO Auto-generated method stub
        return session.insert("mapper.mysql.mapperBoard.insertArticle",article);
    }

    @Override
    public int updateArticle(ModelArticle updateValue,
            ModelArticle searchValue) {
        // TODO Auto-generated method stub
        Map<String,ModelArticle> map = new HashMap<String,ModelArticle>();
        map.put("updateValue", updateValue);
        map.put("searchValue", searchValue);
        return session.insert("mapper.mysql.mapperBoard.updateArticle",map);
    }

    @Override
    public int deleteArticle(ModelArticle article) {
        // TODO Auto-generated method stub
        return session.insert("mapper.mysql.mapperBoard.deleteArticle",article);
    }

    @Override
    public int increaseHit(int articleNo) {
        // TODO Auto-generated method stub
        return session.update("mapper.mysql.mapperBoard.increaseHit",articleNo);
    }

    @Override
    public ModelArticle getNextArticle(String boardcd, Integer articleNo,
            String searchWord) {
        // TODO Auto-generated method stub
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("boardcd", boardcd);
        map.put("articleNo", articleNo);
        map.put("searchWord", searchWord);
        return session.selectOne("mapper.mysql.mapperBoard.getNextArticle",map);
    }

    @Override
    public ModelArticle getPrevArticle(String boardcd, Integer articleNo,
            String searchWord) {
        // TODO Auto-generated method stub
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("boardcd", boardcd);
        map.put("articleNo", articleNo);
        map.put("searchWord", searchWord);
        return session.selectOne("mapper.mysql.mapperBoard.getPrevArticle",map);
    }

    @Override
    public ModelAttachFile getAttachFile(int attachFileno) {
        // TODO Auto-generated method stub
        return session.selectOne("mapper.mysql.mapperBoard.getAttachFile",attachFileno);
    }

    @Override
    public List<ModelAttachFile> getAttachFileList(int articleNo) {
        // TODO Auto-generated method stub
        return session.selectList("mapper.mysql.mapperBoard.getAttachFileList",articleNo);
    }

    @Override
    public int insertAttachFile(ModelAttachFile attachfile) {
        // TODO Auto-generated method stub
        return session.insert("mapper.mysql.mapperBoard.insertAttachFile",attachfile);
    }

    @Override
    public int deleteAttachFile(ModelAttachFile attachfile) {
        // TODO Auto-generated method stub
        return session.insert("mapper.mysql.mapperBoard.deleteAttachFile",attachfile);
    }

    @Override
    public ModelComments getComment(int commontNo) {
        // TODO Auto-generated method stub
        return session.selectOne("mapper.mysql.mapperBoard.getComment",commontNo);
    }

    @Override
    public List<ModelComments> getCommentList(int articleNo) {
        // TODO Auto-generated method stub
        return session.selectList("mapper.mysql.mapperBoard.getCommentList",articleNo);
    }

    @Override
    public int insertComment(ModelComments comments) {
        // TODO Auto-generated method stub
        return session.insert("mapper.mysql.mapperBoard.insertComment",comments);
    }

    @Override
    public int updateComment(ModelComments updateValue,
            ModelComments searchValue) {
        // TODO Auto-generated method stub
        Map<String,ModelComments> map = new HashMap<String,ModelComments>();
        map.put("updateValue",updateValue);
        map.put("searchValue",searchValue);
        return session.update("mapper.mysql.mapperBoard.updateComment",map);
    }

    @Override
    public int deleteComment(ModelComments comments) {
        // TODO Auto-generated method stub
        return session.insert("mapper.mysql.mapperBoard.deleteComment",comments);
    }

    @Override
    public int getMaxArticleno() {
        // TODO Auto-generated method stub
        return session.selectOne("mapper.mysql.mapperBoard.getMaxArticleno");
    }

    @Override
    public int getCommentNo(ModelComments comments) {
        // TODO Auto-generated method stub
        return session.selectOne("mapper.mysql.mapperBoard.getCommentNo",comments);
    }
    
    
    
}
