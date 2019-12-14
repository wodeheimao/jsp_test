package src.com.hu.bms.pojo;

public class Book {

  private long bno;
  private String bname;
  private String author;
  private String publisher;
  private String discount;
  private double zprice;
  private double yprice;


  public long getBno() {
    return bno;
  }

  public void setBno(long bno) {
    this.bno = bno;
  }


  public String getBname() {
    return bname;
  }

  public void setBname(String bname) {
    this.bname = bname;
  }


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }


  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }


  public String getDiscount() {
    return discount;
  }

  public void setDiscount(String discount) {
    this.discount = discount;
  }


  public double getZprice() {
    return zprice;
  }

  public void setZprice(double zprice) {
    this.zprice = zprice;
  }


  public double getYprice() {
    return yprice;
  }

  public void setYprice(double yprice) {
    this.yprice = yprice;
  }

}
