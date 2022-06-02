package com.example.waimai.mapper;


import com.example.waimai.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(Map map);

    List<User> selectByPrimaryKey();

    int updateByPrimaryKeySelective(User record);

    @Select("select * from user1 where openid=#{openid} ")
    List<User> findByuserid(@Param("openid") String userid);

    @Insert("INSERT into user1(nickname,gender,avatarurl,openid) VALUES (#{nickname},#{gender},#{avatarurl},#{openid})")
    void insert(@Param("nickname") String nickname,@Param("gender") String gender, @Param("avatarurl") String avatarurl,@Param("openid") String openid);




}