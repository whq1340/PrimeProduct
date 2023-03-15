package com.example.helloword.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.util.List;

public class User {
    private int id;
    private String username;
    private String password;
    private String birthday;
    private String logontime;
    private String phone;
    //联表查询附件表信息
    @TableField(exist = false)
    private List<Trade> trades;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getLogontime() {
        return logontime;
    }

    public String getPhone() {
        return phone;
    }

    public List<Trade> getTrades() {
        return trades;
    }

    public void setTrades(List<Trade> trades) {
        this.trades = trades;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setLogontime(String logontime) {
        this.logontime = logontime;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday='" + birthday + '\'' +
                ", logontime='" + logontime + '\'' +
                ", phone='" + phone + '\'' +
                ", trades=" + trades +
                '}';
    }
}
