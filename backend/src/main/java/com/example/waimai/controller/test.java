package com.example.waimai.controller;

import com.example.waimai.entity.Order;
import com.example.waimai.entity.Test;
import com.example.waimai.mapper.OrderMapper;
import com.example.waimai.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("test")
public class test {

    @Autowired
    private TestMapper testMapper;


    @RequestMapping("get")
    @ResponseBody
    public List<Test> getorder()
    {

        return testMapper.gettest();

    }





}

