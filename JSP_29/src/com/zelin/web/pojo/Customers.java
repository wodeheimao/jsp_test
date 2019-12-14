package com.zelin.web.pojo;

public class Customers {

  private String cid;
  private String cname;
  private String username;
  private String addr;
  private String phone;
  private String level;
  private String isEnabled;
  private String score;

  public Customers() {
  }

  public Customers(String cid, String cname, String username, String addr, String phone, String level, String isEnabled, String score) {
    this.cid = cid;
    this.cname = cname;
    this.username = username;
    this.addr = addr;
    this.phone = phone;
    this.level = level;
    this.isEnabled = isEnabled;
    this.score = score;
  }

  public Customers(String cname, String username, String addr, String phone, String level, String isEnabled, String score) {
    this.cname = cname;
    this.username = username;
    this.addr = addr;
    this.phone = phone;
    this.level = level;
    this.isEnabled = isEnabled;
    this.score = score;
  }

  public String getCid() {
    return cid;
  }

  public void setCid(String cid) {
    this.cid = cid;
  }


  public String getCname() {
    return cname;
  }

  public void setCname(String cname) {
    this.cname = cname;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }


  public String getIsEnabled() {
    return isEnabled;
  }

  public void setIsEnabled(String isEnabled) {
    this.isEnabled = isEnabled;
  }


  public String getScore() {
    return score;
  }

  public void setScore(String score) {
    this.score = score;
  }

  @Override
  public String toString() {
    return "Customers{" +
            "cid='" + cid + '\'' +
            ", cname='" + cname + '\'' +
            ", username='" + username + '\'' +
            ", addr='" + addr + '\'' +
            ", phone='" + phone + '\'' +
            ", level='" + level + '\'' +
            ", isEnabled='" + isEnabled + '\'' +
            ", score='" + score + '\'' +
            '}';
  }
}
