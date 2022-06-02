package com.example.waimai.mapper;

import com.example.waimai.entity.Order;
import org.apache.ibatis.annotations.*;

import java.sql.Time;
import java.util.List;

@Mapper
public interface OrderMapper

{

    @Insert("INSERT into orders(takeoutinfo,time1,time2,liquid,name,phone,address,placefrom,openid,status) VALUES (#{takeoutinfo},#{time1},#{time2},#{liquid},#{name},#{phone},#{address},#{placefrom},#{openid},#{status}) returning id")
    Integer insertorder(@Param("takeoutinfo") String takeoutinfo,@Param("time1") String time1, @Param("time2") String time2,@Param("liquid") String liquid,@Param("name") String name,@Param("phone") String phone,@Param("address") String address,@Param("placefrom") String placefrom,@Param("openid") String openid,@Param("status") String status);

    @Select("SELECT LAST_INSERT_ID()")
    Integer select_last();
    @Select("select * from orders where status='待接收' and time2>#{k} ")
    List<Order> getorder(Time k);

    @Select("select now()")
    Time gettime();

    @Select("select * from orders where id=(select max(id) from orders) ")
    Order getbymaxid();

    @Select("select * from orders where id=#{id} ")
    Order getbyid(@Param("id") Integer id);
    @Select("select * from orders where liquid=#{liquid} and placefrom=#{placefrom} and status='待接收' ")
    List<Order> get1(@Param("liquid") String liquid,@Param("placefrom") String placefrom);

    @Select("select * from orders where placefrom=#{placefrom} and status='待接收'")
    List<Order> get2(@Param("placefrom") String placefrom);

    @Select("select * from orders where liquid=#{liquid} and status='待接收' ")
    List<Order> get3(@Param("liquid") String liquid);

    @Update("update orders set receiver_openid=#{receiver_openid},status=replace(status,'待接收','派送中') where id=#{id}" )
    void receive(@Param("receiver_openid") String  receiver_openid,@Param("id") Integer id);

    @Update("update orders set status='已完成' where id=#{id}" )
    void finish(@Param("id") Integer id);

    @Update("update orders set status=replace(status,'派送中','已送达') where id=#{id}" )
    void arrive(@Param("id") Integer id);

    @Delete("delete from orders where id= #{id}")
    void delete(@Param("id") Integer id);

    @Update("update orders set receiver_openid=null,status=replace(status,'派送中','待接收') where id=#{id}")
    void cancel(@Param("id") Integer id);

    @Select("select * from orders where openid=#{openid}")
    List<Order> getmyorder(@Param("openid") String openid);

    @Select("select * from orders where receiver_openid=#{receiver_openid}")
    List<Order> getmyreceiveorder(@Param("receiver_openid") String receiver_openid);


}
