package com.wang.WMSys.Service;


import com.wang.WMSys.Pojo.Entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {

    User getUserByUsername(String username);
    int insert(User user);

    String checkLogin(String username, String password);
}
