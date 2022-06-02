package com.example.waimai.controller;

import com.example.waimai.entity.Chatdetail;
import com.example.waimai.entity.Chatroom;
import com.example.waimai.entity.Order;
import com.example.waimai.entity.User;
import com.example.waimai.mapper.ChatdetailMapper;
import com.example.waimai.mapper.ChatroomMapper;
import com.example.waimai.mapper.OrderMapper;
import com.example.waimai.mapper.UserMapper;
import com.example.waimai.service.Chatroomservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("chatroom")
public class ChatroomController {



    @Autowired
    private ChatroomMapper chatroomMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private Chatroomservice chatroomservice;

    @Autowired
    private UserMapper userMapper;


    @RequestMapping("select")
    @ResponseBody
    public List<Chatroom> select( String userid)

    {System.out.println(userid);

        return chatroomMapper.findByUserid(userid);


    }

    @RequestMapping("selectbyuserid")
    @ResponseBody
    public List<Chatroom> selectbyuserid( String userid)

    {System.out.println(chatroomMapper.selectByuserid(userid));


        return chatroomMapper.selectByuserid(userid);


    }

    @RequestMapping("selectbyorderid")
    @ResponseBody
    public Chatroom selectbyorderid( String orderid ,String userid ,String touserid)

    {System.out.println(orderid);

        return chatroomMapper.selectByorderid(orderid,userid,touserid);


    }


    @RequestMapping("add")
    @ResponseBody
    public  void add(Integer id)
    {
         System.out.println(id);
        Order order=new Order();
        order=orderMapper.getbyid(id);
        User user1=new User();
        User user2=new User();
        System.out.println(order.getOpenid());
        user1=userMapper.findByuserid(order.getOpenid()).get(0);
        System.out.println(user1);
        user2=userMapper.findByuserid(order.getReceiver_openid()).get(0);
        System.out.println(user1.getAvatarUrl());

        String ID=Integer.toString(id);


        chatroomservice.save(user1.getOpenId(),user1.getAvatarUrl(),user2.getAvatarUrl(),user2.getNickName(),user2.getOpenId(), "您好，我接受了您的订单","刚刚",ID, order.getTakeoutinfo());
        chatroomservice.save(user2.getOpenId(),user2.getAvatarUrl(),user1.getAvatarUrl(),user1.getNickName(),user1.getOpenId(),"","刚刚",ID,order.getTakeoutinfo());



    }





}
