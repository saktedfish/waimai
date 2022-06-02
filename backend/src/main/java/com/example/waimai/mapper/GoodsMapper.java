package com.example.waimai.mapper;

import com.example.waimai.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface GoodsMapper {





    @Select("select * from goods")
    List<Goods> get();

    @Select("select * from goods where id=#{id}")
    Goods getbyid(@Param("id") Integer id);



}
