package com.example.waimai.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.waimai.mapper.CreditMapper;
import com.example.waimai.mapper.UserMapper;
import com.example.waimai.util.AesCbcUtil;
import com.example.waimai.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserMapper userMapper;


    @Autowired
    private CreditMapper creditMapper;
    @RequestMapping("insert")
    @ResponseBody
    public int insert(String nickname,String gender,String avatarurl,String openid)
    {
        System.out.println(openid);
        userMapper.insert(nickname,gender,avatarurl,openid);

        if(creditMapper.selectbyopenid(openid)==null) {

            creditMapper.insert(openid, 0);
        }


        return 1;

    }


    @RequestMapping("add")
    @ResponseBody
    public Object add(String code, String encryptedData, String iv) {
        System.out.println(code);
        System.out.println(encryptedData);
        System.out.println(iv);
        Map map = new HashMap();
        //登录凭证不能为空
        if (code == null || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return map;
        }
        //小程序唯一标识   (在微信小程序管理后台获取)
        String wxspAppid = "wx90c4f6a585ec8f71";
        //小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = "7e9b1223d8591da626254649e8f12e1a";
        //授权（必填）
        String grant_type = "authorization_code";


        //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
        //请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String sr = HttpUtil.get("https://api.weixin.qq.com/sns/jscode2session?" + params);
        //解析相应内容（转换成json对象）
        JSONObject json = JSONObject.parseObject(sr);
        //获取会话密钥（session_key）
        String session_key = json.get("session_key").toString();
        //用户的唯一标识（openid）
        String openid = (String) json.get("openid");


        //////////////// 2、对encryptedData加密数据进行AES解密 ////////////////
        try {
            String result = AesCbcUtil.getUserInfo(encryptedData, session_key, iv);
            System.out.println(result);

            if (null != result && result.length() > 0) {
                map.put("status", 1);
                map.put("msg", "解密成功");

                JSONObject userInfoJSON = JSONObject.parseObject(result);
                Map userInfo = new HashMap();
                userInfo.put("openId", userInfoJSON.get("openId"));
                userInfo.put("nickName", userInfoJSON.get("nickName"));
                userInfo.put("gender", userInfoJSON.get("gender"));
                userInfo.put("city", userInfoJSON.get("city"));
                userInfo.put("province", userInfoJSON.get("province"));
                userInfo.put("country", userInfoJSON.get("country"));
                userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
                userInfo.put("unionId", userInfoJSON.get("unionId"));


                if (userMapper.findByuserid(userInfo.get("openId").toString()) == null) {
                    userMapper.insertSelective(userInfo);
                }
                map.put("userInfo", userInfo);
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("status", 0);
        map.put("msg", "解密失败");
        return map;
    }
}