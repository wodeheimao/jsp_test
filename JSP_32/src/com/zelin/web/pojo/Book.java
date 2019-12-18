package com.zelin.web.pojo;

public class Book {

  private String bno;
  private String bname;
  private String author;
  private String publisher;
  private String yprice;
  private String zprice;
  private String discount;
  private String cno;
  private String cname;

  public Book() {
  }

  public Book(String bno, String bname, String author, String publisher, String yprice, String zprice, String discount, String cno) {
    this.bno = bno;
    this.bname = bname;
    this.author = author;
    this.publisher = publisher;
    this.yprice = yprice;
    this.zprice = zprice;
    this.discount = discount;
    this.cno = cno;
  }

  public String getCname() {
    return cname;
  }

  public void setCname(String cname) {
    this.cname = cname;
  }

  public String getBno() {
    return bno;
  }

  public void setBno(String bno) {
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

  public String getYprice() {
    return yprice;
  }

  public void setYprice(String yprice) {
    this.yprice = yprice;
  }

  public String getZprice() {
    return zprice;
  }

  public void setZprice(String zprice) {
    this.zprice = zprice;
  }

  public String getDiscount() {
    return discount;
  }

  public void setDiscount(String discount) {
    this.discount = discount;
  }

  public String getCno() {
    return cno;
  }

  public void setCno(String cno) {
    this.cno = cno;
  }

  @Override
  public String toString() {
    return "Book{" +
            "bno='" + bno + '\'' +
            ", bname='" + bname + '\'' +
            ", author='" + author + '\'' +
            ", publisher='" + publisher + '\'' +
            ", yprice='" + yprice + '\'' +
            ", zprice='" + zprice + '\'' +
            ", discount='" + discount + '\'' +
            ", cno='" + cno + '\'' +
            '}';
  }
}
