package com.wang.WMSys.mapper;

import com.wang.WMSys.Pojo.Entity.User;

/**
* @author yiwan
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2024-05-17 16:56:25
* @Entity com.wang.WMSys.Pojo.Entity.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
