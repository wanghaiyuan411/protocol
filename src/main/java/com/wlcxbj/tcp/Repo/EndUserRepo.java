package com.wlcxbj.tcp.Repo;

import com.wlcxbj.tcp.entity.EndUser;
import org.springframework.data.repository.CrudRepository;

public interface EndUserRepo extends CrudRepository<EndUser, Long> {
    EndUser findByLoginName(String loginName);
}
