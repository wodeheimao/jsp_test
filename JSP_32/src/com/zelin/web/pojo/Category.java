package com.zelin.web.pojo;

public class Category {

  private String cno;
  private String cname;
  private String ccontent;

  public Category() {
  }

  public Category(String cno, String cname, String ccontent) {
    this.cno = cno;
    this.cname = cname;
    this.ccontent = ccontent;
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


  public String getCcontent() {
    return ccontent;
  }

  public void setCcontent(String ccontent) {
    this.ccontent = ccontent;
  }

  @Override
  public String toString() {
    return "Category{" +
            "cno='" + cno + '\'' +
            ", cname='" + cname + '\'' +
            ", ccontent='" + ccontent + '\'' +
            '}';
  }
}
