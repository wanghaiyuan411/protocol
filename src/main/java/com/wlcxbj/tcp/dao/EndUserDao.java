package com.wlcxbj.tcp.dao;

import com.wlcxbj.tcp.entity.EndUser;

public interface EndUserDao {
    EndUser saveEndUser(EndUser endUser, int code);

    EndUser findEndUser(Long endUserId);
}
