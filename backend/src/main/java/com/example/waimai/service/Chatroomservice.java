package com.example.waimai.service;

import com.example.waimai.mapper.ChatroomMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Chatroomservice {

    @Autowired
    private ChatroomMapper chatroomMapper;


    public void update( String  lasttime,  String lastcontent, String userid,  String touserid, String orderid)
    {
        Integer a=chatroomMapper.selectmaxid()+1;
        chatroomMapper.update(a,lasttime,lastcontent,userid,touserid,orderid);
    }

    public void save( String userid,String userimg,String touserimg,String tousernickname,String touserid,String lastcontent,String lasttime,String orderid,String ordername)
    {
        Integer a=chatroomMapper.selectmaxid()+1;
        chatroomMapper.save1(a,userid,userimg,touserimg,tousernickname,touserid,lastcontent,lasttime,orderid,ordername);
    }




}
