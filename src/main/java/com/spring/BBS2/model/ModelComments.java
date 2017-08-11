package com.spring.BBS2.model;

import java.util.Date;

public class ModelComments {
    
  private Integer commentno = null; //commentno     INT UNSIGNED     NOT NULL AUTO_INCREMENT
  private Integer articleno = null; //articleno     INT UNSIGNED     NOT NULL     
  private String userid     = ""; //email         NVARCHAR(60)  
  private String memo      = ""; //memo          NVARCHAR(4000)
  private Date regdate   = null; //regdate       DateTime                  
  private Boolean UseYN     = null; //UseYN         TINYINT(1)       NULL     DEFAULT  1                               
  private String InsertUID = ""; //InsertUID     VARCHAR(40)      NULL                            
  private Date InsertDT  = null; //InsertDT      DateTime         NULL
  private String UpdateUID = ""; //UpdateUID     VARCHAR(40)      NULL                            
  private Date UpdateDT  = null; //UpdateDT      DateTime         NULL
public Integer getCommentno() {
    return commentno;
}
public void setCommentno(Integer commentno) {
    this.commentno = commentno;
}
public Integer getArticleno() {
    return articleno;
}
public void setArticleno(Integer articleno) {
    this.articleno = articleno;
}
public String getUserid() {
    return userid;
}
public void setUserid(String userid) {
    this.userid = userid;
}
public String getMemo() {
    return memo;
}
public void setMemo(String memo) {
    this.memo = memo;
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
public ModelComments(Integer commentno, Integer articleno, String userid,
        String memo, Date regdate, Boolean useYN, String insertUID,
        Date insertDT, String updateUID, Date updateDT) {
    super();
    this.commentno = commentno;
    this.articleno = articleno;
    this.userid = userid;
    this.memo = memo;
    this.regdate = regdate;
    UseYN = useYN;
    InsertUID = insertUID;
    InsertDT = insertDT;
    UpdateUID = updateUID;
    UpdateDT = updateDT;
}
public ModelComments() {
    super();
}
public ModelComments(int articleno) {
    this.articleno = articleno;
}
public ModelComments(Integer articleno, String memo) {
    this.articleno = articleno;
    this.memo = memo;
}
@Override
public String toString() {
    return "ModelComments [commentno=" + commentno + ", articleno=" + articleno
            + ", userid=" + userid + ", memo=" + memo + ", regdate=" + regdate
            + ", UseYN=" + UseYN + ", InsertUID=" + InsertUID + ", InsertDT="
            + InsertDT + ", UpdateUID=" + UpdateUID + ", UpdateDT=" + UpdateDT
            + "]";
}
  
  
    
}
