package com.spring.BBS2.model;

import java.util.Date;

public class ModelBoard {

  private String boardcd   = ""; //   boardcd       NVARCHAR(20)   NOT NULL
  private String boardnm   = ""; // , boardnm       NVARCHAR(40)   NOT NULL                                
  private Boolean UseYN     = null; // , UseYN         TINYINT(1)     NOT NULL   DEFAULT  1                        
  private String InsertUID = ""; // , InsertUID     VARCHAR(40)    NULL                            
  private Date InsertDT  = null; // , InsertDT      DateTime       NULL
  private String UpdateUID = ""; // , UpdateUID     VARCHAR(40)    NULL                            
  private Date UpdateDT  = null; // , UpdateDT      DateTime       NULL
public String getBoardcd() {
    return boardcd;
}
public void setBoardcd(String boardcd) {
    this.boardcd = boardcd;
}
public String getBoardnm() {
    return boardnm;
}
public void setBoardnm(String boardnm) {
    this.boardnm = boardnm;
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
public ModelBoard(String boardcd, String boardnm, Boolean useYN,
        String insertUID, Date insertDT, String updateUID, Date updateDT) {
    super();
    this.boardcd = boardcd;
    this.boardnm = boardnm;
    UseYN = useYN;
    InsertUID = insertUID;
    InsertDT = insertDT;
    UpdateUID = updateUID;
    UpdateDT = updateDT;
}
public ModelBoard() {
    super();
}
@Override
public String toString() {
    return "ModelBoard [boardcd=" + boardcd + ", boardnm=" + boardnm
            + ", UseYN=" + UseYN + ", InsertUID=" + InsertUID + ", InsertDT="
            + InsertDT + ", UpdateUID=" + UpdateUID + ", UpdateDT=" + UpdateDT
            + "]";
}
public Boolean getUseYN() {
    return UseYN;
}
public void setUseYN(Boolean useYN) {
    UseYN = useYN;
}
    
  
  
  
}
