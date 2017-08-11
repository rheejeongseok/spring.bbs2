package com.spring.BBS2.model;

import java.util.Date;

public class ModelArticle {

  private Integer articleno = null; //  articleno     INT UNSIGNED  NOT NULL AUTO_INCREMENT
  private String boardcd   = "";    //, boardcd       NVARCHAR(20)
  private String userid = "";
  private String title     = "";    //, title         NVARCHAR(200) NOT NULL
  private String content   = "";    //, content       MEDIUMTEXT
  private String email     = "";    //, email         NVARCHAR(60)
  private Integer hit       = null; //, hit           INT UNSIGNED  DEFAULT  0   
  private Date regdate   = null;    //, regdate       DateTime
  private Boolean UseYN     = null; //, UseYN         TINYINT(1)    NOT NULL   DEFAULT  1                    
  private String InsertUID = "";    //, InsertUID     VARCHAR(40)   NULL                            
  private Date InsertDT  = null;    //, InsertDT      DateTime      NULL
  private String UpdateUID = "";    //, UpdateUID     VARCHAR(40)   NULL                            
  private Date UpdateDT  = null;    //, UpdateDT      DateTime      NULL
  private Integer attachfileNum = 0;
  private Integer commentNum = 0;
  
public Integer getArticleno() {
    return articleno;
}
public void setArticleno(Integer articleno) {
    this.articleno = articleno;
}
public String getBoardcd() {
    return boardcd;
}
public void setBoardcd(String boardcd) {
    this.boardcd = boardcd;
}
public String getTitle() {
    return title;
}
public void setTitle(String title) {
    this.title = title;
}
public String getContent() {
    return content;
}
public void setContent(String content) {
    this.content = content;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public Integer getHit() {
    return hit;
}
public void setHit(Integer hit) {
    this.hit = hit;
}
public Date getRegdate() {
    return regdate;
}
public void setRegdate(Date regdate) {
    this.regdate = regdate;
}
public Boolean getUseYN() {
    return UseYN;
}
public void setUseYN(Boolean useYN) {
    UseYN = useYN;
}
public String getInsertUID() {
    return InsertUID;
}
public void setInsertUID(String insertUID) {
    InsertUID = insertUID;
}
public Date getInsertDT() {
    return InsertDT;
}
public void setInsertDT(Date insertDT) {
    InsertDT = insertDT;
}
public String getUpdateUID() {
    return UpdateUID;
}
public void setUpdateUID(String updateUID) {
    UpdateUID = updateUID;
}
public Date getUpdateDT() {
    return UpdateDT;
}
public void setUpdateDT(Date updateDT) {
    UpdateDT = updateDT;
}
public ModelArticle(Integer articleno, String boardcd, String title,
        String content, String email, Integer hit, Date regdate, Boolean useYN,
        String insertUID, Date insertDT, String updateUID, Date updateDT) {
    super();
    this.articleno = articleno;
    this.boardcd = boardcd;
    this.title = title;
    this.content = content;
    this.email = email;
    this.hit = hit;
    this.regdate = regdate;
    UseYN = useYN;
    InsertUID = insertUID;
    InsertDT = insertDT;
    UpdateUID = updateUID;
    UpdateDT = updateDT;
}
public ModelArticle() {
    super();
}
@Override
public String toString() {
    return "ModelArticle [articleno=" + articleno + ", boardcd=" + boardcd
            + ", title=" + title + ", content=" + content + ", email=" + email
            + ", hit=" + hit + ", regdate=" + regdate + ", UseYN=" + UseYN
            + ", InsertUID=" + InsertUID + ", InsertDT=" + InsertDT
            + ", UpdateUID=" + UpdateUID + ", UpdateDT=" + UpdateDT + "]";
}
public Integer getAttachfileNum() {
    return attachfileNum;
}
public void setAttachfileNum(Integer attachfileNum) {
    this.attachfileNum = attachfileNum;
}
public Integer getCommentNum() {
    return commentNum;
}
public void setCommentNum(Integer commentNum) {
    this.commentNum = commentNum;
}
public String getUserid() {
    return userid;
}
public void setUserid(String userid) {
    this.userid = userid;
}
    
   
  
}