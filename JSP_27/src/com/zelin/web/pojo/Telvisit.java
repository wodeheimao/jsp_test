package com.zelin.web.pojo;

import java.sql.Timestamp;

public class Telvisit {

  private int tno;
  private String tname;
  private String ttime;
  private String tclass;
  private String tresult;
  private String tway;
  private String tcno;

  public Telvisit() {
  }

  public Telvisit(String tname, String ttime, String tclass, String tresult, String tway, String tcno) {
    this.tname = tname;
    this.ttime = ttime;
    this.tclass = tclass;
    this.tresult = tresult;
    this.tway = tway;
    this.tcno = tcno;
  }

  public Telvisit(int tno, String tname, String ttime, String tclass, String tresult, String tway, String tcno) {
    this.tno = tno;
    this.tname = tname;
    this.ttime = ttime;
    this.tclass = tclass;
    this.tresult = tresult;
    this.tway = tway;
    this.tcno = tcno;
  }

  public int getTno() {
    return tno;
  }

  public void setTno(int tno) {
    this.tno = tno;
  }


  public String getTname() {
    return tname;
  }

  public void setTname(String tname) {
    this.tname = tname;
  }


  public String getTtime() {
    return ttime;
  }

  public void setTtime(String ttime) {
    this.ttime = ttime;
  }


  public String getTclass() {
    return tclass;
  }

  public void setTclass(String tclass) {
    this.tclass = tclass;
  }


  public String getTresult() {
    return tresult;
  }

  public void setTresult(String tresult) {
    this.tresult = tresult;
  }


  public String getTway() {
    return tway;
  }

  public void setTway(String tway) {
    this.tway = tway;
  }


  public String getTcno() {
    return tcno;
  }

  public void setTcno(String tcno) {
    this.tcno = tcno;
  }

  @Override
  public String toString() {
    return "Telvisit{" +
            "tno=" + tno +
            ", tname='" + tname + '\'' +
            ", ttime='" + ttime + '\'' +
            ", tclass='" + tclass + '\'' +
            ", tresult='" + tresult + '\'' +
            ", tway='" + tway + '\'' +
            ", tcno='" + tcno + '\'' +
            '}';
  }
}
