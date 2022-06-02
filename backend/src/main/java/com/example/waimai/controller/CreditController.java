package com.example.waimai.controller;

import com.example.waimai.entity.Goods;
import com.example.waimai.entity.User;
import com.example.waimai.mapper.BuyrecordMapper;
import com.example.waimai.mapper.CreditMapper;
import com.example.waimai.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("credit")
public class CreditController {

@Autowired
private GoodsMapper goodsMapper;

@Autowired
private CreditMapper creditMapper;

@Autowired
private BuyrecordMapper buyrecordMapper;


    @RequestMapping("buy")
    @ResponseBody
    public Integer getbyid(Integer id,String openid)

    {
        System.out.println(id);
        System.out.println(openid);


        Integer credit=creditMapper.selectcredit(openid);

        Goods goods=new Goods();
        goods=goodsMapper.getbyid(id);
        String creditneed= goods.getCredit();
        String name=goods.getName();
        Integer creditneed1=Integer.parseInt(creditneed);
        if(credit>=creditneed1)
        {
            creditMapper.updatebuy(creditneed1,openid);
            buyrecordMapper.insert(name,openid);

            return 1;
        }
        else {
            return 0;
        }



    }

    @RequestMapping("getcredit")
    @ResponseBody
    public Integer getcredit(String openid)

    {
       return  creditMapper.selectcredit(openid);



    }

}
