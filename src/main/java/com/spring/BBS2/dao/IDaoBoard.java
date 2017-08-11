package com.spring.BBS2.dao;

import java.util.List;

import com.spring.BBS2.model.ModelArticle;
import com.spring.BBS2.model.ModelAttachFile;
import com.spring.BBS2.model.ModelBoard;
import com.spring.BBS2.model.ModelComments;


public interface IDaoBoard {
    
    String getBoardName(String boardcd);
    ModelBoard getBoardOne(String boardcd);
    List<ModelBoard> getBoardList();
    int insertBoard(ModelBoard board);
    int updateBoard(ModelBoard updateValue,ModelBoard searchValue);
    int deleteBoard(ModelBoard board);
    List<ModelBoard> getBoardSearch(ModelBoard board);
    List<ModelBoard> getBoardPaging(String boardnm,String boardcd,String searchWord,Integer start,Integer end);
    int insertBoardList(List<ModelBoard> list);
    int getArticleTotalRecord(String boardcd, String searchWord);
    List<ModelArticle> getArticleList(String boardcd, String searchWord, Integer start, Integer end);
    ModelArticle getArticle(int articleNo);
    int getMaxArticleno();
    int insertArticle(ModelArticle article);
    int updateArticle(ModelArticle updateValue,ModelArticle searchValue);
    int deleteArticle(ModelArticle article);
    int increaseHit(int articleNo);
    ModelArticle getNextArticle(String boardcd, Integer articleNo, String searchWord);
    ModelArticle getPrevArticle(String boardcd, Integer articleNo, String searchWord);
    ModelAttachFile getAttachFile(int attachFileno);
    List<ModelAttachFile> getAttachFileList(int articleNo);
    int insertAttachFile(ModelAttachFile attachfile);
    int deleteAttachFile(ModelAttachFile attachfile);
    ModelComments getComment(int commontNo);
    List<ModelComments> getCommentList(int articleNo);
    int insertComment(ModelComments comments);
    int updateComment(ModelComments updateValue,ModelComments searchValue);
    int deleteComment(ModelComments comments);
    int getCommentNo(ModelComments comments);
    
}
