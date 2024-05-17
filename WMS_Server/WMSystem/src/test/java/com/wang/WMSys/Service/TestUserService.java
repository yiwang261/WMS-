package com.wang.WMSys.Service;

import com.wang.WMSys.Pojo.Entity.User;
import com.wang.WMSys.Service.Impl.UserServiceImpl;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class TestUserService {
    @Resource
    UserService userService;

    @Resource
    PasswordEncoder passwordEncoder;
    @Test
    public void testSelectByUsername()
    {
        User user = userService.getUserByUsername("admin");
        System.out.println(user);
    }

    @Test
    public void encrypt(){
        System.out.println(passwordEncoder.encode("123456"));
    }
}
