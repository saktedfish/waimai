package com.example.waimai.mapper;

import com.example.waimai.entity.Order;
import com.example.waimai.entity.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface TestMapper {
    @Select("select * from test ")
    List<Test> gettest();

}
