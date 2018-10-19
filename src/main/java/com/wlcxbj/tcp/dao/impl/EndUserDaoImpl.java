package com.wlcxbj.tcp.dao.impl;

import com.wlcxbj.tcp.Repo.EndUserRepo;
import com.wlcxbj.tcp.dao.EndUserDao;
import com.wlcxbj.tcp.entity.EndUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
@Component
public class EndUserDaoImpl implements EndUserDao {
    @Resource
    private EndUserRepo endUserRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public EndUser saveEndUser(EndUser endUser, int code) {
        endUser.setLoginPwd(passwordEncoder.encode(String.valueOf(code)));
        return endUserRepo.save(endUser);
    }

    @Override
    public EndUser findEndUser(Long endUserId) {
        return endUserRepo.findOne(endUserId);
    }
}
