package com.nys.project.bean;

public class Book {
    private String bkid;
    private String bkname;
    private String author;
    private String tid;

    public Book() {
    }

    public Book(String bkid, String bkname, String author, String tid) {
        this.bkid = bkid;
        this.bkname = bkname;
        this.author = author;
        this.tid = tid;
    }

    public String getBkid() {
        return bkid;
    }

    public void setBkid(String bkid) {
        this.bkid = bkid;
    }

    public String getBkname() {
        return bkname;
    }

    public void setBkname(String bkname) {
        this.bkname = bkname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bkid='" + bkid + '\'' +
                ", bkname='" + bkname + '\'' +
                ", author='" + author + '\'' +
                ", tid='" + tid + '\'' +
                '}';
    }
}
