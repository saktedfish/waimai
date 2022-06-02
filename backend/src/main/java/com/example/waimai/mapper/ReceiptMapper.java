package com.example.waimai.mapper;

import com.example.waimai.entity.Receipt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
@Mapper
public interface ReceiptMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Receipt record);

    List<Receipt> selectByPrimaryKey(@Param("userid") String userid);
    @Select("select * from receipt where userId=#{openid} order by id desc limit 0,1")
    Map sel(@Param("openid") String openid);
    @Select("select count(1) from receipt where userId=#{openId}")
    int count(@Param("openId") String openId);

    @Select("select * from receipt where userid=#{userid}")
    List<Receipt> get(@Param("userid") String userid);
}