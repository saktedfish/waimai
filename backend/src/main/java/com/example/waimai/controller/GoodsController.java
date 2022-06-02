package com.example.waimai.controller;

import com.example.waimai.entity.Buyrecord;
import com.example.waimai.entity.Goods;
import com.example.waimai.entity.User;
import com.example.waimai.mapper.BuyrecordMapper;
import com.example.waimai.mapper.GoodsMapper;
import com.example.waimai.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BuyrecordMapper buyrecordMapper;


    @RequestMapping("get")
    @ResponseBody
    public List<Goods> get()
    {
        return goodsMapper.get();


    }

    @RequestMapping("getbyid")
    @ResponseBody
    public Goods getbyid(Integer id)

    {

        return goodsMapper.getbyid(id);


    }

    @RequestMapping("getrecord")
    @ResponseBody
    public List<Buyrecord> getrecord(String openid)

    {

        return buyrecordMapper.getrecord(openid);


    }





}
