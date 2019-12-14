package com.zelin.web.pojo;

public class Dept {

  private String did;
  private String dname;
  private String content;

  public Dept() {
  }

  public Dept(String did, String dname, String content) {
    this.did = did;
    this.dname = dname;
    this.content = content;
  }

  public String getDid() {
    return did;
  }

  public void setDid(String did) {
    this.did = did;
  }


  public String getDname() {
    return dname;
  }

  public void setDname(String dname) {
    this.dname = dname;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return "Dept{" +
            "did='" + did + '\'' +
            ", dname='" + dname + '\'' +
            ", content='" + content + '\'' +
            '}';
  }
}
