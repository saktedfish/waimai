package com.example.waimai.controller;

import com.example.waimai.entity.Order;
import com.example.waimai.mapper.CreditMapper;
import com.example.waimai.mapper.OrderMapper;
import com.example.waimai.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@Controller
@RequestMapping("order")
public class OrderController {

   @Autowired
    private OrderMapper orderMapper;

   @Autowired
   private CreditMapper creditMapper;

   @Autowired
   private UserMapper userMapper;

    @RequestMapping("insert")
    @ResponseBody
   public Integer insert(@RequestBody Order order)

   {
         System.out.println(order.getTime2());

       int a=orderMapper.insertorder(order.getTakeoutinfo(),order.getTime1(),order.getTime2(),order.getLiquid(),order.getName(),order.getPhone(), order.getAddress(), order.getPlacefrom(),order.getOpenid(),order.getStatus());

       return a;


   }

    @RequestMapping("get")
    @ResponseBody
    public List<Order> getorder()
    {
        Time k=orderMapper.gettime();

        System.out.println(k);


      return orderMapper.getorder(k);

    }

    @RequestMapping("getbyid")
    @ResponseBody
    public Order getbyid( Integer id)
    {
        System.out.println(id);

        return orderMapper.getbyid(id);

    }

    @RequestMapping("get_id")
    @ResponseBody
    public Order get_id(Integer id)
    {

        return orderMapper.getbymaxid();

    }


    @RequestMapping("select")
    @ResponseBody
    public List<Order> selectorder(String liquid,String placefrom )

    {

        if(!liquid.equals("2")&&!(placefrom.equals("不限")))
        { System.out.println(1);
            return orderMapper.get1(liquid,placefrom);
        }
        if(liquid.equals("2")&&!(placefrom.equals("不限")))
        {


            return orderMapper.get2(placefrom);
        }
        if(!liquid.equals("2")&&(placefrom.equals("不限")))
        {
            return orderMapper.get3(liquid);
        }
        else
        {
            Time k=orderMapper.gettime();

            return orderMapper.getorder(k);
        }

    }


    @RequestMapping("receive")
    @ResponseBody
    public void receive(String receiver_openid,Integer id)
    {


        orderMapper.receive(receiver_openid,id);

    }

//    我的订单状态改变
    @RequestMapping("change")
    @ResponseBody
    public void receive(Integer id,String who)
    {
//        完成订单后加积分
        if(who.equals("0"))
        {
            orderMapper.finish(id);
            Order order=new Order();
            order=orderMapper.getbyid(id);
            String k=order.getReceiver_openid();

            creditMapper.updatecredit(k);




        }
       else if(who.equals("1"))
        {
            orderMapper.arrive(id);
        }
        else if(who.equals("2"))
        {
            orderMapper.delete(id);
        }
        else
        {
            orderMapper.cancel(id);
        }





    }


    @RequestMapping("cancel")
    @ResponseBody
    public void receive(Integer id)
    {

        System.out.println(id);

        orderMapper.cancel(id);

    }

    @RequestMapping("getmyreceiveorder")
    @ResponseBody
    public List<Order> getmyreceiveorder(String openid)
    {

        System.out.println(openid);

        return orderMapper.getmyreceiveorder(openid);

    }

    @RequestMapping("getmyorder")
    @ResponseBody
    public List<Order> getmyorder(String openid)
    {

        System.out.println(openid);

       return orderMapper.getmyorder(openid);

    }




}
