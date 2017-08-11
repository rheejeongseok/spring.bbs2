package com.spring.BBS2.model;

import java.util.Date;

public class ModelUser {
    
  private Integer userno    = 0; //userno        INT UNSIGNED    NOT NULL AUTO_INCREMENT
  private String username  = ""; //username        NVARCHAR( 50)    NOT NULL
  private String userid    = ""; //userid         NVARCHAR(100)   NOT NULL
  private String password  = ""; //password        NVARCHAR( 30) NOT NULL   
  private String email     = ""; //email          NVARCHAR( 30) NOT NULL
  private String postcode     = ""; //email          NVARCHAR( 30) NOT NULL
  private String roadAddress     = ""; //email          NVARCHAR( 30) NOT NULL
  private String jibunAddress     = ""; //email          NVARCHAR( 30) NOT NULL
  private String phone     = ""; //phone        NVARCHAR(20) NOT NULL       
  private Boolean retireYN  = null; //retireYN      TINYINT(1)      NULL     DEFAULT  1                   

public ModelUser(Integer userno) {
    this.userno = userno;
}
public ModelUser(String userid) {
    this.userid = userid;
}
public Integer getUserno() {
    return userno;
}
public void setUserno(Integer userno) {
    this.userno = userno;
}
public String getUsername() {
    return username;
}
public void setUsername(String username) {
    this.username = username;
}
public String getUserid() {
    return userid;
}
public void setUserid(String userid) {
    this.userid = userid;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public String getPostcode() {
    return postcode;
}
public void setPostcode(String postcode) {
    this.postcode = postcode;
}
public String getRoadAddress() {
    return roadAddress;
}
public void setRoadAddress(String roadAddress) {
    this.roadAddress = roadAddress;
}
public String getJibunAddress() {
    return jibunAddress;
}
public void setJibunAddress(String jibunAddress) {
    this.jibunAddress = jibunAddress;
}
public String getPhone() {
    return phone;
}
public void setPhone(String phone) {
    this.phone = phone;
}
public Boolean getRetireYN() {
    return retireYN;
}
public void setRetireYN(Boolean retireYN) {
    this.retireYN = retireYN;
}
public ModelUser(Integer userno, String username, String userid,
        String password, String email, String postcode, String roadAddress,
        String jibunAddress, String phone, Boolean retireYN) {
    super();
    this.userno = userno;
    this.username = username;
    this.userid = userid;
    this.password = password;
    this.email = email;
    this.postcode = postcode;
    this.roadAddress = roadAddress;
    this.jibunAddress = jibunAddress;
    this.phone = phone;
    this.retireYN = retireYN;
}
public ModelUser() {
    super();
}
@Override
public String toString() {
    return "ModelUser [userno=" + userno + ", username=" + username
            + ", userid=" + userid + ", password=" + password + ", email="
            + email + ", postcode=" + postcode + ", roadAddress=" + roadAddress
            + ", jibunAddress=" + jibunAddress + ", phone=" + phone
            + ", retireYN=" + retireYN + "]";
}
  
  
    
}
