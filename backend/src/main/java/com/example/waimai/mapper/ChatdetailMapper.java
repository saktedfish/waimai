package com.example.waimai.mapper;

import com.example.waimai.entity.Chatdetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChatdetailMapper {


     @Select("select * from chatdetail where userid=#{userid} and touserid=#{touserid} and orderid=#{orderid}")
      List<Chatdetail> findbyUseridAndTouseridAndOrderid(@Param("userid") String userid,@Param("touserid") String touserid,@Param("orderid") String orderid);

     @Insert("INSERT into chatdetail(userid,touserid,content,speaker,orderid) VALUES (#{userid},#{touserid},#{content},#{speaker},#{orderid})")
     void save(@Param("userid") String userid,@Param("touserid") String touserid,@Param("content") String content,@Param("speaker") String speaker,@Param("orderid") String orderid);

}
