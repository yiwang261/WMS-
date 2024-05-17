package com.wang.WMSys.Mapper;


import com.wang.WMSys.Pojo.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author yiwan
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2024-05-17 16:45:54
* @Entity src/main/java/com/wang/WMSys/Mapper.Entity.User
*/
@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    User getUserByUsername(String username);

}
