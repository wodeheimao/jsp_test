package src.com.hu.bms.pojo;


public class Shopcart {

  private long sid;
  private long gid;
  private long goodnums;
  private double goodsprice;
  private String gname;

  public Shopcart() {
  }

  public Shopcart(long sid, long gid, long goodnums, double goodsprice, String gname) {
    this.sid = sid;
    this.gid = gid;
    this.goodnums = goodnums;
    this.goodsprice = goodsprice;
    this.gname = gname;
  }

  public long getSid() {
    return sid;
  }

  public void setSid(long sid) {
    this.sid = sid;
  }


  public long getGid() {
    return gid;
  }

  public void setGid(long gid) {
    this.gid = gid;
  }


  public long getGoodnums() {
    return goodnums;
  }

  public void setGoodnums(long goodnums) {
    this.goodnums = goodnums;
  }


  public double getGoodsprice() {
    return goodsprice;
  }

  public void setGoodsprice(double goodsprice) {
    this.goodsprice = goodsprice;
  }

  public String getGname() {
    return gname;
  }

  public void setGname(String gname) {
    this.gname = gname;
  }

  @Override
  public String toString() {
    return "Shopcart{" +
            "sid=" + sid +
            ", gid=" + gid +
            ", goodnums=" + goodnums +
            ", goodsprice=" + goodsprice +
            ", gname='" + gname + '\'' +
            '}';
  }
}
