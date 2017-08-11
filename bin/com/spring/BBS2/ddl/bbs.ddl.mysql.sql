DROP DATABASE IF EXISTS bbs2;

CREATE DATABASE bbs2 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS TB_User;
CREATE TABLE TB_User (
      userno        INT UNSIGNED    NOT NULL AUTO_INCREMENT
    , username        NVARCHAR( 50)    NOT NULL
    , userid         NVARCHAR(100)   NOT NULL
    , password        NVARCHAR( 30) NOT NULL   
    , email          NVARCHAR( 30) NOT NULL
    , phone        NVARCHAR(20) NOT NULL       
    , retireYN      TINYINT(1)      NULL     DEFAULT  1  
                                     
    , InsertUID     VARCHAR(40)     NULL                            
    , InsertDT      DateTime        NULL
    , UpdateUID     VARCHAR(40)     NULL                            
    , UpdateDT      DateTime        NULL
    
    , PRIMARY KEY(userno)
    , UNIQUE KEY(userid)
)
ENGINE=InnoDB 
AUTO_INCREMENT=1 
DEFAULT CHARACTER SET utf8 
COLLATE utf8_general_ci;