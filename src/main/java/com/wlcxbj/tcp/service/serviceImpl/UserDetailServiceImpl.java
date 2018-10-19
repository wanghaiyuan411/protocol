package com.wlcxbj.tcp.service.serviceImpl;

import com.wlcxbj.tcp.Repo.EndUserRepo;
import com.wlcxbj.tcp.entity.EndUser;
import com.wlcxbj.tcp.entity.JwtEndUser;
import lombok.extern.log4j.Log4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Log4j
public class UserDetailServiceImpl implements UserDetailsService{
    @Resource
    private EndUserRepo endUserRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EndUser endUser = endUserRepo.findByLoginName(username);
        if (endUser == null){
            return null;
        }
        JwtEndUser userDetails = new JwtEndUser();
        userDetails.setId(endUser.getId());
        userDetails.setUsername(username);
        userDetails.setCreatedTime(endUser.getCreatedTime());
        userDetails.setUpdatedTime(endUser.getUpdatedTime());
        userDetails.setAccountNonExpired(endUser.isAccountnonexpired());
        userDetails.setAccountNonLocked(endUser.isAccountnonlocked());
        userDetails.setCredentialsNonExpired(endUser.isCredentialsnonexpired());
        userDetails.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(endUser.getRole())));
        log.info("...........isCredentialsnonexpired = " + userDetails.isCredentialsNonExpired());
        userDetails.setPassword(endUser.getLoginPwd());
        userDetails.setEnabled(true);
        return userDetails;
    }
    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

}
