package com.wang.WMSys.Utils;

import com.alibaba.fastjson2.JSON;

public class JSONUtil {


    private JSONUtil(){};
    public static String toJSONString(Object object){
        return JSON.toJSONString(object);
    }

    public static <T> T parseObject(String json, Class<T> clazz){
        return JSON.parseObject(json,clazz);
    }
}
