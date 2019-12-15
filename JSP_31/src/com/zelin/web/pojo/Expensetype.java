package com.zelin.web.pojo;

public class Expensetype {

  private String tid;
  private String tname;
  private String tdisc;

  public Expensetype() {
  }

  public Expensetype(String tid, String tname, String tdisc) {
    this.tid = tid;
    this.tname = tname;
    this.tdisc = tdisc;
  }

  public String getTid() {
    return tid;
  }

  public void setTid(String tid) {
    this.tid = tid;
  }


  public String getTname() {
    return tname;
  }

  public void setTname(String tname) {
    this.tname = tname;
  }


  public String getTdisc() {
    return tdisc;
  }

  public void setTdisc(String tdisc) {
    this.tdisc = tdisc;
  }

  @Override
  public String toString() {
    return "Expensetype{" +
            "tid='" + tid + '\'' +
            ", tname='" + tname + '\'' +
            ", tdisc='" + tdisc + '\'' +
            '}';
  }
}
