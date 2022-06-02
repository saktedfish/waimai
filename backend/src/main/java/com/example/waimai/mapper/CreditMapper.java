package com.example.waimai.mapper;

import org.apache.ibatis.annotations.*;

@Mapper
public interface CreditMapper {



    @Select("select * from credit where openid=#{openid}")
    String selectbyopenid (@Param("openid") String openid);

    @Update("update credit set credit=credit+10 where openid=#{openid}")
    void updatecredit(@Param("openid") String openid);

    @Insert("insert into credit (openid,credit) VALUES(#{openid},#{credit})")
    void insert(@Param("openid") String openid ,@Param("credit") Integer credit);

    @Select("select credit from credit where openid=#{openid}")
    Integer selectcredit(@Param("openid") String openid);

    @Update("update credit set credit=credit-#{creditneed1} where openid=#{openid}")
    void updatebuy(@Param("creditneed1") Integer creditneed1, @Param("openid") String openid);


}
