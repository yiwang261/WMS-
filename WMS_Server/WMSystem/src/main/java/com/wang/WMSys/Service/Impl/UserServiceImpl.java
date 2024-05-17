package com.wang.WMSys.Service.Impl;


import com.wang.WMSys.Mapper.UserMapper;

import com.wang.WMSys.Pojo.Entity.User;
import com.wang.WMSys.Service.UserService;
import com.wang.WMSys.Utils.Const;
import com.wang.WMSys.Utils.JSONUtil;
import com.wang.WMSys.Utils.JWTUtil;
import com.wang.WMSys.Utils.Result;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private RedisService<String,String> redisService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getUserByUsername(username);

        //TODO 后续查询角色信息
        return user;
    }
    @Override
    public int insert(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userMapper.insert(user);
    }

    @Override
    public String checkLogin(String username, String password) {
        User user = this.getUserByUsername(username);
        if(ObjectUtils.isEmpty(user))
            return null;

        if(bCryptPasswordEncoder.matches(password,user.getPassword())){
            String token = JWTUtil.createToken(user);
            System.out.println(token);
            redisService.set(Const.REDIS_KEY+user.getPkId(),token);
            redisService.expire(Const.REDIS_KEY+user.getPkId(),Const.DEFAULT_EXPIRE_TIME, TimeUnit.MILLISECONDS);
            return JSONUtil.toJSONString(token);
        }
        return null;
    }


    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }
}
