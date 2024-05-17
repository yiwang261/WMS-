package com.wang.WMSys.Controller;

import com.wang.WMSys.Pojo.Entity.User;
import com.wang.WMSys.Service.Impl.RedisService;
import com.wang.WMSys.Service.UserService;
import com.wang.WMSys.Utils.Const;
import com.wang.WMSys.Utils.JWTUtil;
import com.wang.WMSys.Utils.Result;
import jakarta.annotation.Resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Resource
    UserService userService;

    @Resource
    RedisService<String,User> redisService;

    @GetMapping("/login")
    public Result login(@RequestParam("username") String username,
                        @RequestParam("password") String password){

        String token = userService.checkLogin(username, password);

        if(token == null){
            return Result.error("登录失败");
        }
        return  Result.success(token);
    }

    @RequestMapping("/index")
    public String index(){
        System.out.println("index");
        return "登陆成功";
    }
    @RequestMapping("/logout")
    public String logout(){
        System.out.println("logout");

        //TODO 移除reidis中的用户信息
        return "退出成功";
    }
}
