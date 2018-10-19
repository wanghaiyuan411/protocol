package com.wlcxbj.http.model.requestModel;

import com.wlcxbj.http.model.RespBase;

public class ReqAccountResp extends RespBase {
    private long userId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ReqAccountResp{" +
                "userId=" + userId +
                '}';
    }
}
