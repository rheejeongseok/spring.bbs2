package com.spring.BBS2.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.BBS2.dao.IDaoUpload;
import com.spring.BBS2.model.ModelUploadFile;
import com.spring.BBS2.model.ModelUploadImage;



@Service("serviceupload")
public class ServiceUpload implements IServiceUpload {

    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
   
    @Autowired
    @Qualifier("daoupload")
    private IDaoUpload uploaddao;

    @Override
    public int insertAttachFile(ModelUploadFile attachfile) {
        
        int result = -1;
        try {
            result = uploaddao.insertAttachFile(attachfile);
        } catch (Exception e) {
            logger.error("insertAttachFile " + e.getMessage() );
        }
        
        return result;
    }


    @Override
    public int insertPhoto(ModelUploadImage attachfile) {
        
        int result = -1;
        
        try {
            result = uploaddao.insertPhoto(attachfile);
        } catch (Exception e) {
            logger.error("insertAttachFile " + e.getMessage() );
        }
        
        return result;
    }
    

    @Override
    public List<ModelUploadImage> getImageByteList(int articleno) {
        List<ModelUploadImage> result = null;
        try {
            result = uploaddao.getImageByteList(articleno);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getImageByteList" + e.getMessage() );
            throw e;
        }
        return result;
    }


    @Override
    public ModelUploadImage getImageByteOne(int articleno, int uploadImageNo) {
        ModelUploadImage result = null;
        try {
            result = uploaddao.getImageByteOne(articleno, uploadImageNo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getImageByteOne" + e.getMessage() );
            throw e;
        }
        return result;
    }


    @Override
    public int deletePhoto(int articleno, int uploadImageNo) {
        int result = -1;
        try {
            result = uploaddao.deletePhoto(articleno, uploadImageNo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("deletePhoto" + e.getMessage() );
            throw e;
        }
        return result;
    }    
}
