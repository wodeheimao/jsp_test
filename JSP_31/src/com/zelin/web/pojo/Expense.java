package com.zelin.web.pojo;

public class Expense {

    private String exid;
    private String ename;
    private String areasion;
    private String adate;
    private String amoney;
    private String pmoney;
    private String astatus;
    private String tid;
    private String tname;

    public Expense() {
    }

    public Expense(String exid, String ename, String areasion, String adate, String amoney, String pmoney, String astatus, String tid, String tname) {
        this.exid = exid;
        this.ename = ename;
        this.areasion = areasion;
        this.adate = adate;
        this.amoney = amoney;
        this.pmoney = pmoney;
        this.astatus = astatus;
        this.tid = tid;
        this.tname = tname;
    }

    public Expense(String ename, String areasion, String tname, String amoney, String adate, String tid,String astatus) {
        this.ename = ename;
        this.areasion = areasion;
        this.adate = adate;
        this.amoney = amoney;
        this.astatus = astatus;
        this.tid = tid;
        this.tname = tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPmoney() {
        return pmoney;
    }

    public void setPmoney(String pmoney) {
        this.pmoney = pmoney;
    }

    public String getExid() {
        return exid;
    }

    public void setExid(String exid) {
        this.exid = exid;
    }

    public String getTname() {
        return tname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }


    public String getAreasion() {
        return areasion;
    }

    public void setAreasion(String areasion) {
        this.areasion = areasion;
    }


    public String getAdate() {
        return adate;
    }

    public void setAdate(String adate) {
        this.adate = adate;
    }


    public String getAmoney() {
        return amoney;
    }

    public void setAmoney(String amoney) {
        this.amoney = amoney;
    }


    public String getAstatus() {
        return astatus;
    }

    public void setAstatus(String astatus) {
        this.astatus = astatus;
    }


    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "exid='" + exid + '\'' +
                ", ename='" + ename + '\'' +
                ", areasion='" + areasion + '\'' +
                ", adate='" + adate + '\'' +
                ", amoney='" + amoney + '\'' +
                ", pmoney='" + pmoney + '\'' +
                ", astatus='" + astatus + '\'' +
                ", tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                '}';
    }
}
