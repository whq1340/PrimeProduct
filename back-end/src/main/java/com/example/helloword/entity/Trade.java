package com.example.helloword.entity;

public class Trade {
    private int id;
    private int uid;
    private String createtime;
    private String tradename;
    private int number;
    private float price;

    public void setId(int id) {
        this.id = id;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public void setTradename(String tradename) {
        this.tradename = tradename;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getUid() {
        return uid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public String getTradename() {
        return tradename;
    }

    public int getNumber() {
        return number;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", uid=" + uid +
                ", createtime='" + createtime + '\'' +
                ", tradename='" + tradename + '\'' +
                ", number=" + number +
                ", price=" + price +
                '}';
    }
}
