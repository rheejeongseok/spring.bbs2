package com.spring.BBS2.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring.BBS2.model.ModelUploadFile;
import com.spring.BBS2.model.ModelUploadImage;


@Repository("daoupload")
public class DaoUpload implements IDaoUpload {

    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    
    public int insertAttachFile(ModelUploadFile attachfile) {
        return session.insert("mapper.mapperUpload.insertAttachFile",attachfile);
    }

    public int insertPhoto(ModelUploadImage attachfile) {
        
       /*Oracle 용 
        Map<String, Object> map = new  HashMap<String, Object>();
        map.put("file"  , attachfile);
        map.put("result", null);
        
        session.insert("mapper.mapperUpload.insertPhoto", map);
        int result = map.get("result") != null ? (int) map.get("result") : -1;
        
        return result;
        */
        
        session.insert("mapper.mapperUpload.insertPhoto", attachfile );
        return attachfile.getUploadImageNo();
    }
    
       @Override
    public List<ModelUploadImage> getImageByteList(int articleno) {
        // TODO Auto-generated method stub
        return session.selectList("mapper.mapperUpload.getImageByteList",articleno);
    }

    @Override
    public ModelUploadImage getImageByteOne(int articleno, int uploadImageNo) {
        Map<String, Integer> map = new HashMap<String,Integer>();
        map.put("articleno", articleno);
        map.put("uploadImageNo", uploadImageNo);
        return session.selectOne("mapper.mapperUpload.getImageByteOne",map);
    }

    @Override
    public int deletePhoto(int articleno, int uploadImageNo) {
        
        Map<String, Integer> map = new HashMap<String,Integer>();
        map.put("articleno", articleno);
        map.put("uploadImageNo", uploadImageNo);
        return session.delete("mapper.mapperUpload.deletePhoto",map);
    }
}
