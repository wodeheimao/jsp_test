package com.zelin.web.pojo;

public class Companyinfo {

  private String cno;
  private String cname;
  private String fname;
  private String fphone;
  private String cprofile;

  public Companyinfo() {
  }

  public Companyinfo(String cno, String cname, String fname, String fphone, String cprofile) {
    this.cno = cno;
    this.cname = cname;
    this.fname = fname;
    this.fphone = fphone;
    this.cprofile = cprofile;
  }

  public String getCno() {
    return cno;
  }

  public void setCno(String cno) {
    this.cno = cno;
  }


  public String getCname() {
    return cname;
  }

  public void setCname(String cname) {
    this.cname = cname;
  }


  public String getFname() {
    return fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }


  public String getFphone() {
    return fphone;
  }

  public void setFphone(String fphone) {
    this.fphone = fphone;
  }


  public String getCprofile() {
    return cprofile;
  }

  public void setCprofile(String cprofile) {
    this.cprofile = cprofile;
  }

  @Override
  public String toString() {
    return "Companyinfo{" +
            "cno='" + cno + '\'' +
            ", cname='" + cname + '\'' +
            ", fname='" + fname + '\'' +
            ", fphone='" + fphone + '\'' +
            ", cprofile='" + cprofile + '\'' +
            '}';
  }
}
