package com.zelin.web.pojo;

public class Bankuai {

  private long pid;
  private String pname;
  private String psign;

  public Bankuai() {
  }

  public Bankuai(long pid, String pname, String psign) {
    this.pid = pid;
    this.pname = pname;
    this.psign = psign;
  }

  public long getPid() {
    return pid;
  }

  public void setPid(long pid) {
    this.pid = pid;
  }


  public String getPname() {
    return pname;
  }

  public void setPname(String pname) {
    this.pname = pname;
  }


  public String getPsign() {
    return psign;
  }

  public void setPsign(String psign) {
    this.psign = psign;
  }

}
