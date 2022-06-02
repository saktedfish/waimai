package com.example.waimai.controller;

import com.example.waimai.entity.Chatdetail;
import com.example.waimai.entity.Chatroom;
import com.example.waimai.mapper.ChatdetailMapper;
import com.example.waimai.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("chatdetail")
public class ChatdetailController {

    @Autowired
    private  ChatdetailMapper chatdetailMapper;



    @RequestMapping("select")
    @ResponseBody
    public List<Chatdetail> select( String userid, String touserid,String orderid)
    {
        System.out.println(userid);
        System.out.println(touserid);
        System.out.println(11111111);

        return chatdetailMapper.findbyUseridAndTouseridAndOrderid(userid,touserid,orderid);


    }




}
