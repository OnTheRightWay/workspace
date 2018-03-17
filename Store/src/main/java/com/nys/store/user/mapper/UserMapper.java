package com.nys.store.user.mapper;


import com.nys.store.user.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM basic_user WHERE phone=#{phone} and password = #{password}")
    User selectUserByLogin(User user);

    @Select("SELECT * FROM basic_user WHERE phone=#{value}")
    User selectUserByPhone(String phone);

    @Select("SELECT * FROM basic_user WHERE user_name=#{value}")
    User selectUserByUsername(String user_name);

    @Insert("insert basic_user(user_name,password,phone) values(#{user_name},#{password},#{phone})")
    void insertUser(User user);
}
