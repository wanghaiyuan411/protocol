package com.wlcxbj.tcp.service.serviceImpl;

import com.wlcxbj.tcp.entity.EndUser;
import com.wlcxbj.tcp.model.EndUserModel;

public interface EndUserService {
   EndUserModel saveEndUser(EndUser endUser, int code);
   EndUserModel findByEndUserId(Long endUserId);
}
