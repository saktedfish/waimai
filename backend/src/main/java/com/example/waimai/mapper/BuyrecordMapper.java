package com.example.waimai.mapper;

import com.example.waimai.entity.Buyrecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BuyrecordMapper {


    @Insert("insert into buyrecord (goodsname,openid)VALUES(#{goodsname},#{openid}) ")
    void insert(@Param("goodsname") String goodsname ,@Param("openid") String openid);

    @Select("select * from buyrecord where openid=#{openid}")
    List<Buyrecord> getrecord(@Param("openid") String openid);
}
