package com.xiaoping.websocket.mapper;

import com.xiaoping.websocket.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into user (username,password) values (#{username},#{password})")
    public int insertUser(User user);

    @Select("select * from user where id=#{id}")
    public User selectUserById(Integer id);

    @Select("select * from user where username=#{username}")
    public User selectUserByUsername(String username);


}
