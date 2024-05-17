package com.wang.WMSys.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.wang.WMSys.Pojo.Entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


import java.util.Map;


//@Configuration
//@PropertySource("classpath:JWT.properties")
public class JWTUtil {
//    @Value("${SECRET_KEY}")
    public static  String SECRET = "jdopwqjdpwqjopd";
    public static final Algorithm algorithm = Algorithm.HMAC256(SECRET);

    public static String createToken(User user){
        Map<String,Object> header = Map.of("alg","HS256","typ","JWT");
        return JWT.create()
                .withHeader(header)
                .withClaim("user",JSONUtil.toJSONString(user))
                .sign(algorithm);
    }

    public static <T> T parseToken(String token,String key ,Class<T> clazz) throws JWTDecodeException {
        return JSONUtil.parseObject(JWT.decode(token).getClaim(key).asString(),clazz);
    }

}
