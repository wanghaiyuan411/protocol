package com.wlcxbj.tcp.service.serviceImpl;

import com.wlcxbj.tcp.dao.EndUserDao;
import com.wlcxbj.tcp.entity.EndUser;
import com.wlcxbj.tcp.model.EndUserModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
@Service
public class EndUserServiceImpl implements EndUserService{
    @Resource
    private EndUserDao endUserDao;


    @Override
    public EndUserModel saveEndUser(EndUser endUser, int code) {
        endUser = endUserDao.saveEndUser(endUser, code);
        ModelMapper mapper = new ModelMapper();
        return mapper.map(endUser, EndUserModel.class);
    }

    @Override
    public EndUserModel findByEndUserId(Long endUserId) {
        EndUser endUser = endUserDao.findEndUser(endUserId);
        if (endUser == null){
            return null;
        }
        ModelMapper mapper = new ModelMapper();
        return mapper.map(endUser, EndUserModel.class);
    }
}
