package com.zelin.web.pojo;

public class Fatie {

    private long tid;
    private String title;
    private String tname;
    private String topflag;
    private String pubdate;
    private String msgcontent;
    private long pid;
    private String pname;

    public Fatie() {
    }

    public Fatie(String title, String tname, String topflag, String pubdate, String msgcontent, long pid, String pname) {
        this.title = title;
        this.tname = tname;
        this.topflag = topflag;
        this.pubdate = pubdate;
        this.msgcontent = msgcontent;
        this.pid = pid;
        this.pname = pname;
    }

    public Fatie(long tid, String title, String tname, String topflag, String pubdate, String msgcontent, long pid, String pname) {
        this.tid = tid;
        this.title = title;
        this.tname = tname;
        this.topflag = topflag;
        this.pubdate = pubdate;
        this.msgcontent = msgcontent;
        this.pid = pid;
        this.pname = pname;
    }

    public Fatie(int tid, String title, String msgcontent, int pid) {
        this.tid = tid;
        this.title = title;
        this.msgcontent = msgcontent;
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }


    public String getTopflag() {
        return topflag;
    }

    public void setTopflag(String topflag) {
        this.topflag = topflag;
    }


    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }


    public String getMsgcontent() {
        return msgcontent;
    }

    public void setMsgcontent(String msgcontent) {
        this.msgcontent = msgcontent;
    }


    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

}
