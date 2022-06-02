package com.example.waimai.controller;

import com.example.waimai.entity.Receipt;
import com.example.waimai.mapper.DorderMapper;
import com.example.waimai.mapper.ReceiptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("receipt")
public class ReceiptController {
    @Autowired
    private ReceiptMapper receiptMapper;
    @Autowired
    private DorderMapper dorderMapper;
    @RequestMapping("add")
    @ResponseBody
    public void add(String name,String phone,String address,String userid){
        Receipt receipt=new Receipt();
        receipt.setAddress(address);
        receipt.setName(name);
        receipt.setPhone(phone);
        receipt.setUserid(userid);
        receiptMapper.insertSelective(receipt);
    }

    @RequestMapping("get")
    @ResponseBody
    public List<Receipt> get(String userid){

        return receiptMapper.get(userid);
    }
    @RequestMapping("getList")
    @ResponseBody
    public Object getList(String userid){
        return receiptMapper.selectByPrimaryKey(userid);
    }
    @RequestMapping("del")
    @ResponseBody
    public void del(Integer id){
        receiptMapper.deleteByPrimaryKey(id);
    }
    @RequestMapping("getUser")
    @ResponseBody
    public Object getUser(String openId,String dorderuId){
        Map map=receiptMapper.sel(openId);
        List<Map> maps= dorderMapper.getList(dorderuId);
        Map map1=new HashMap();
        map1.put("user",map);
        map1.put("maps",maps);
        return map1;
    }
    @RequestMapping("count")
    @ResponseBody
    public Object count(String openId){
        return receiptMapper.count(openId);
    }
}

