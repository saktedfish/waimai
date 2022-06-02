package com.example.waimai.mapper;

import com.example.waimai.entity.Chatdetail;
import com.example.waimai.entity.Chatroom;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChatroomMapper {

    @Select("select * from chatroom where userid=#{userid} and touserid=#{touserid}")
    Chatroom findByUseridAndTouserid(@Param("userid") String userid, @Param("touserid") String touserid);

    @Select("select * from chatroom where userid=#{userid}")
    List<Chatroom> findByUserid(@Param("userid") String userid);

    @Select("select * from chatroom where userid=#{userid} ORDER BY id DESC")
    List<Chatroom> selectByuserid(@Param("userid") String userid);

    @Select("select * from chatroom where orderid=#{orderid} and userid=#{userid} and touserid=#{touserid} ")
    Chatroom selectByorderid(@Param("orderid") String orderid,@Param("userid") String userid,@Param("touserid") String touserid);
    @Insert("INSERT into chatroom(id,userid,userimg,touserimg,tousernickname,touserid,lastcontent,lasttime,orderid,ordername) VALUES (#{id},#{userid},#{userimg},#{touserimg},#{tousernickname},#{touserid},#{lastcontent},#{lasttime},#{orderid},#{ordername})")
    void save1(@Param("id") Integer id,@Param("userid") String userid,@Param("userimg") String userimg,@Param("touserimg") String touserimg,@Param("tousernickname") String tousernickname,@Param("touserid") String touserid,@Param("lastcontent") String lastcontent,@Param("lasttime") String lasttime,@Param("orderid") String orderid,@Param("ordername") String ordername);

    @Select("select max(id) from chatroom")
    Integer selectmaxid();
    @Update("update chatroom set id=#{id},lasttime=#{lasttime},lastcontent=#{lastcontent} where userid=#{userid} and touserid=#{touserid} and orderid=#{orderid}" )
    void update(@Param("id") Integer a,@Param("lasttime") String  lasttime,@Param("lastcontent") String lastcontent,@Param("userid") String userid,@Param("touserid") String touserid,@Param("orderid") String orderid);
}
