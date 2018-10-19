package com.wlcxbj.http.model.responseModel;

import com.wlcxbj.http.model.RespBase;
import com.wlcxbj.tcp.model.EndUserModel;

public class RespAccountModel extends RespBase{
    private EndUserModel endUserModel;

    public EndUserModel getEndUserModel() {
        return endUserModel;
    }

    public void setEndUserModel(EndUserModel endUserModel) {
        this.endUserModel = endUserModel;
    }

    @Override
    public String toString() {
        return "RespAccountModel{" +
                "endUserModel=" + endUserModel +
                '}';
    }
    /*private Long userId;
    private String username;
    private Long balance;
    private String dataTranslate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getDataTranslate() {
        return dataTranslate;
    }

    public void setDataTranslate(String dataTranslate) {
        this.dataTranslate = dataTranslate;
    }

    @Override
    public String toString() {
        return "RespAccountModel{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                ", dataTranslate='" + dataTranslate + '\'' +
                '}';
    }*/
}
