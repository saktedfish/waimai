package com.example.waimai.mapper;

import com.example.waimai.entity.Dorder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
@Mapper
public interface DorderMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Dorder record);

    Dorder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dorder record);
    @Select("SELECT (SUM(money)+1) from dorder WHERE orderId=#{orderId} and dorder.type=1  and dorder.cid in (SELECT id from dishes WHERE canteen=#{st})")
    Integer sel(@Param("orderId")String orderId, @Param("st") String st);
    @Select("SELECT * from dorder,`order` WHERE dorder.orderId=`order`.dorderuId and `order`.id=#{orderId}")
    List<Dorder> get(@Param("orderId") String orderId);
    @Select("SELECT dishes.* from dorder,dishes WHERE dishes.id=dorder.cid and dorder.orderId=#{dorderuId}")
    List<Map> getList(@Param("dorderuId") String dorderuId);
    @Select("SELECT  dorder.money as money,type,dishes.canteen from dorder,dishes WHERE userId=#{userId} and orderId=#{orderId} and dishes.id=dorder.cid")
    List<Map> findList(@Param("userId") String userId,@Param("orderId") String orderId);
    @Select("SELECT dishes.`name`,canteen,path,dorder.num,dorder.money from dorder,dishes WHERE dishes.id=dorder.cid and dorder.orderId=#{orderId}")
    List<Map> findListByOrderId(@Param("orderId")String orderId);
    @Select("SELECT  dorder.money as money,type,dishes.canteen,dorder.userId from dorder,dishes WHERE orderId=#{orderId} and dishes.id=dorder.cid")
    List<Map> getAll(@Param("orderId") String orderId);
}
