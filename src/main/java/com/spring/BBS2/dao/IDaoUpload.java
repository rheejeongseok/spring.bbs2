package com.spring.BBS2.dao;

import java.util.List;

import com.spring.BBS2.model.ModelUploadFile;
import com.spring.BBS2.model.ModelUploadImage;

public interface IDaoUpload {
   
    int insertAttachFile(ModelUploadFile attachfile);
    int insertPhoto(ModelUploadImage attachfile);    
    List<ModelUploadImage> getImageByteList(int articleno);
    ModelUploadImage getImageByteOne(int articleno, int uploadImageNo);
    int deletePhoto(int articleno, int uploadImageNo);
}
