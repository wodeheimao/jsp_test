package com.hu.bms.pojo;



public class Commentb {

  private long cno;
  private String ctitle;
  private String isre;
  private String content;
  private String cdate;
  private long bno;

  public Commentb() {
  }

  public Commentb(String ctitle, String isre, String content, String cdate, long bno) {
    this.ctitle = ctitle;
    this.isre = isre;
    this.content = content;
    this.cdate = cdate;
    this.bno = bno;
  }

  public Commentb(long cno, String ctitle, String isre, String content, String cdate, long bno) {
    this.cno = cno;
    this.ctitle = ctitle;
    this.isre = isre;
    this.content = content;
    this.cdate = cdate;
    this.bno = bno;
  }

  public long getCno() {
    return cno;
  }

  public void setCno(long cno) {
    this.cno = cno;
  }


  public String getCtitle() {
    return ctitle;
  }

  public void setCtitle(String ctitle) {
    this.ctitle = ctitle;
  }


  public String getIsre() {
    return isre;
  }

  public void setIsre(String isre) {
    this.isre = isre;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getCdate() {
    return cdate;
  }

  public void setCdate(String cdate) {
    this.cdate = cdate;
  }


  public long getBno() {
    return bno;
  }

  public void setBno(long bno) {
    this.bno = bno;
  }

  @Override
  public String toString() {
    return "Commentb{" +
            "cno=" + cno +
            ", ctitle='" + ctitle + '\'' +
            ", isre='" + isre + '\'' +
            ", content='" + content + '\'' +
            ", cdate=" + cdate +
            ", bno=" + bno +
            '}';
  }
}
