package com.zelin.web.pojo;


import java.sql.Date;

public class Emp {

  private String eid;
  private String ename;
  private String username;
  private String phone;
  private String eamil;
  private String status;
  private Date bdate;
  private String sex;
  private String did;

  public Emp() {
  }

  public Emp(String eid, String ename, String username, String phone, String eamil, String status, Date bdate, String sex, String did) {
    this.eid = eid;
    this.ename = ename;
    this.username = username;
    this.phone = phone;
    this.eamil = eamil;
    this.status = status;
    this.bdate = bdate;
    this.sex = sex;
    this.did = did;
  }

  public Emp(String eid, String ename, String username, String phone, String eamil,String status, String did) {
    this.eid = eid;
    this.ename = ename;
    this.username = username;
    this.phone = phone;
    this.eamil = eamil;
    this.status = status;
    this.did = did;
  }

  public String getEid() {
    return eid;
  }

  public void setEid(String eid) {
    this.eid = eid;
  }


  public String getEname() {
    return ename;
  }

  public void setEname(String ename) {
    this.ename = ename;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getEamil() {
    return eamil;
  }

  public void setEamil(String eamil) {
    this.eamil = eamil;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public Date getBdate() {
    return bdate;
  }

  public void setBdate(Date bdate) {
    this.bdate = bdate;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String getDid() {
    return did;
  }

  public void setDid(String did) {
    this.did = did;
  }

  @Override
  public String toString() {
    return "Emp{" +
            "eid='" + eid + '\'' +
            ", ename='" + ename + '\'' +
            ", username='" + username + '\'' +
            ", phone='" + phone + '\'' +
            ", eamil='" + eamil + '\'' +
            ", status='" + status + '\'' +
            ", bdate='" + bdate + '\'' +
            ", sex='" + sex + '\'' +
            ", did='" + did + '\'' +
            '}';
  }
}
