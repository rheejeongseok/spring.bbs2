package com.spring.BBS2.service;

import com.spring.BBS2.dao.IDaoBoard;
import com.spring.BBS2.model.ModelArticle;
import com.spring.BBS2.model.ModelComments;

public interface IServiceBoard extends IDaoBoard {
    
    ModelArticle transUpdateHitAndGetArticle(int articleNo);
    
}
