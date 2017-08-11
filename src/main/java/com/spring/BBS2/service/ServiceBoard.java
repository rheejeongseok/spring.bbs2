package com.spring.BBS2.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.BBS2.dao.IDaoBoard;
import com.spring.BBS2.model.ModelArticle;
import com.spring.BBS2.model.ModelAttachFile;
import com.spring.BBS2.model.ModelBoard;
import com.spring.BBS2.model.ModelComments;



@Service("serviceboard")
public class ServiceBoard implements IServiceBoard {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceBoard.class);
    
    @Autowired
    @Qualifier("daoboard")
    IDaoBoard daoboard;
    
    @Override
    public String getBoardName(String boardcd) {
        
        String result = null;
        
        try {
            result = daoboard.getBoardName(boardcd);
        } catch (Exception e) {
            logger.error("getBoardName" + e.getMessage() );
            throw e;
        }
        
        return result;
    }
    
    @Override
    public ModelBoard getBoardOne(String boardcd) {
        
        ModelBoard result = null;
        
        try {
            result = daoboard.getBoardOne(boardcd);
        } catch (Exception e) {
            logger.error("getBoardOne" + e.getMessage() );
            throw e;
        }
        
        return result;
    }
    
    @Override
    public List<ModelBoard> getBoardList() {
        
        List<ModelBoard> result = null;
        
        try {
            result = daoboard.getBoardList();
        } catch (Exception e) {
            logger.error("getBoardList" + e.getMessage() );
            throw e;
        }
        
        return result;
    }
    
    @Override
    public int insertBoard(ModelBoard board) {
        
        int result = -1;
        
        try {
            result = daoboard.insertBoard(board);
        } catch (Exception e) {
            logger.error("insertBoard" + e.getMessage() );
            throw e;
        }
        
        return result;
    }
    
    @Override
    public int updateBoard(ModelBoard updateValue, ModelBoard searchValue) {
        
        int result = -1;
        
        try {
            result = daoboard.updateBoard(updateValue, searchValue);
        } catch (Exception e) {
            logger.error("updateBoard" + e.getMessage() );
            throw e;
        }
        
        return result;
    }
    
    @Override
    public int deleteBoard(ModelBoard board) {
        
        int result = -1;
        
        try {
            result = daoboard.deleteBoard(board);
        } catch (Exception e) {
            logger.error("deleteBoard" + e.getMessage() );
            throw e;
        }
        
        return result;
    }
    
    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) {
        
        List<ModelBoard> result = null;
        
        try {
            result = daoboard.getBoardSearch(board);
        } catch (Exception e) {

            logger.error("getBoardSearch" + e.getMessage() );
            throw e;
        }
        
        return result;
    }
    
    @Override
    public List<ModelBoard> getBoardPaging(String boardnm, String boardcd,
            String searchWord, Integer start, Integer end) {
        
        List<ModelBoard> result = null;
        
        try {
            result = daoboard.getBoardPaging(boardnm, boardcd, searchWord, start, end);
        } catch (Exception e) {

            logger.error("getBoardPaging" + e.getMessage() );
            throw e;
        }
        
        return result;
    }
    
    @Override
    public int insertBoardList(List<ModelBoard> list) {
        
        int result = -1;
        
        try {
            result = daoboard.insertBoardList(list);
        } catch (Exception e) {

            logger.error("insertBoardList" + e.getMessage() );
            throw e;
        }
        
        return result;
    }
    
    @Override
    public int getArticleTotalRecord(String boardcd, String searchWord) {
        
        int result = -1;
        
        try {
            result = daoboard.getArticleTotalRecord(boardcd, searchWord);
        } catch (Exception e) {
            logger.error("getArticleTotalRecord" + e.getMessage() );
            throw e;
        }
        
        return result;
    }
    
    @Override
    public List<ModelArticle> getArticleList(String boardcd, String searchWord,
            Integer start, Integer end) {
        List<ModelArticle> result = null;
        try {
            result = daoboard.getArticleList(boardcd, searchWord, start, end);
        } catch (Exception e) {

            logger.error("getArticleList" + e.getMessage() );
            throw e;
        }
        return result;
    }
    
    @Override
    public ModelArticle getArticle(int articleNo) {
        
        ModelArticle result = null;
        try {
//                     daoboard.increaseHit(articleNo);
            result = daoboard.getArticle(articleNo);
        } catch (Exception e) {

            logger.error("getArticle" + e.getMessage() );
            throw e;
        }
        
        return result;
    }
    
    @Override
    public int insertArticle(ModelArticle article) {
        
        int result = -1;
        try {
            result = daoboard.insertArticle(article);
        } catch (Exception e) {

            logger.error("insertArticle" + e.getMessage() );
            throw e;
        }
        return result;
    }
    
    @Override
    public int updateArticle(ModelArticle updateValue,
            ModelArticle searchValue) {
        int result = -1;
        try {
            result = daoboard.updateArticle(updateValue, searchValue);
        } catch (Exception e) {

            logger.error("updateArticle" + e.getMessage() );
            throw e;
        }
        return result;
    }
    
    @Override
    public int deleteArticle(ModelArticle article) {
        
        int result = -1;
        
        int articleno = article.getArticleno();
        ModelComments comment = new ModelComments(articleno);
        result = daoboard.deleteComment(comment);
        
        result = daoboard.deleteArticle(article);
        
        return result;
    }
    
    @Override
    public int increaseHit(int articleNo) {
        
        int result = -1;
        try {
            result = daoboard.increaseHit(articleNo);
        } catch (Exception e) {

            logger.error("increaseHit" + e.getMessage() );
            throw e;
        }
        return result;
    }
    
    @Override
    public ModelArticle getNextArticle(String boardcd, Integer articleNo,
            String searchWord) {
        ModelArticle result = null;
        try {
            result = daoboard.getNextArticle(boardcd, articleNo, searchWord);
        } catch (Exception e) {

            logger.error("getNextArticle" + e.getMessage() );
            throw e;
        }
        return result;
    }
    
    @Override
    public ModelArticle getPrevArticle(String boardcd, Integer articleNo,
            String searchWord) {
        ModelArticle result = null;
        try {
            result = daoboard.getPrevArticle(boardcd, articleNo, searchWord);
        } catch (Exception e) {

            logger.error("getPrevArticle" + e.getMessage() );
            throw e;
        }
        return result;
    }
    
    @Override
    public ModelAttachFile getAttachFile(int attachFileno) {
        ModelAttachFile result = null;
        try {
            result = daoboard.getAttachFile(attachFileno);
        } catch (Exception e) {

            logger.error("getAttachFile" + e.getMessage() );
            throw e;
        }
        return result;
    }
    
    @Override
    public List<ModelAttachFile> getAttachFileList(int articleNo) {
        List<ModelAttachFile> result = null;
        try {
            result = daoboard.getAttachFileList(articleNo);
        } catch (Exception e) {

            logger.error("getAttachFileList" + e.getMessage() );
            throw e;
        }
        return result;
    }
    
    @Override
    public int insertAttachFile(ModelAttachFile attachfile) {
        int result = -1;
        try {
            result = daoboard.insertAttachFile(attachfile);
        } catch (Exception e) {

            logger.error("insertAttachFile" + e.getMessage() );
            throw e;
        }
                
        return result;
    }
    
    @Override
    public int deleteAttachFile(ModelAttachFile attachfile) {
        int result = -1;
        try {
            result = daoboard.deleteAttachFile(attachfile);
        } catch (Exception e) {

            logger.error("deleteAttachFile" + e.getMessage() );
            throw e;
        }
        return result;
    }
    
    @Override
    public ModelComments getComment(int commontNo) {
        ModelComments result = null;
        try {
            result = daoboard.getComment(commontNo);
        } catch (Exception e) {

            logger.error("getComment" + e.getMessage() );
            throw e;
        }
        return result;
    }
    
    @Override
    public List<ModelComments> getCommentList(int articleNo) {
        List<ModelComments> result = null;
        try {
            result = daoboard.getCommentList(articleNo);
        } catch (Exception e) {

            logger.error("getCommentList" + e.getMessage() );
            throw e;
        }
        return result;
    }
    
    @Override
    public int insertComment(ModelComments comments) {
        int result = -1;
        try {
            result = daoboard.insertComment(comments);
        } catch (Exception e) {

            logger.error("insertComment" + e.getMessage() );
            throw e;
        }
        return result;
    }
    
    @Override
    public int updateComment(ModelComments updateValue,
            ModelComments searchValue) {
        int result = -1;
        try {
            result = daoboard.updateComment(updateValue, searchValue);
        } catch (Exception e) {

            logger.error("updateComment" + e.getMessage() );
            throw e;
        }
        return result;
    }
    
    @Override
    public int deleteComment(ModelComments comments) {
        int result = -1;
        try {
            result = daoboard.deleteComment(comments);
        } catch (Exception e) {

            logger.error("deleteComment" + e.getMessage() );
            throw e;
        }
        return result;
    }

    @Override
    public int getMaxArticleno() {
        
        int result = -1;
        
        try {
            result = daoboard.getMaxArticleno();
        } catch (Exception e) {
            logger.error("getMaxArticleno" + e.getMessage() );
            throw e;
        }
        
        return result;
    }

    @Override
    public ModelArticle transUpdateHitAndGetArticle(int articleNo) {

        ModelArticle result = null;
        try {
                     daoboard.increaseHit(articleNo);
            result = daoboard.getArticle(articleNo);
        } catch (Exception e) {

            logger.error("transUpdateHitAndGetArticle" + e.getMessage() );
            throw e;
        }
        
        return result;
    }

    @Override
    public int getCommentNo(ModelComments comments) {
        
        int result = 0;
        
        try {
            result = daoboard.getCommentNo(comments);
        } catch (Exception e) {

            logger.error("getCommentNo" + e.getMessage() );
            throw e;
        }
        
        return result;
    }
}
