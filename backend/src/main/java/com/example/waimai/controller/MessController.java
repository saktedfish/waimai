package com.example.waimai.controller;

import com.example.waimai.controller.BaseController;
import com.example.waimai.mapper.ChatdetailMapper;
import com.example.waimai.mapper.ChatroomMapper;
import com.example.waimai.mapper.UserMapper;
import com.example.waimai.entity.Chatdetail;
import com.example.waimai.entity.Chatroom;
import com.example.waimai.entity.User;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


import com.example.waimai.mapper.ChatdetailMapper;
import com.example.waimai.mapper.ChatroomMapper;
import com.example.waimai.mapper.UserMapper;
import com.example.waimai.service.Chatroomservice;
import org.json.JSONObject;
//import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Component;

@Component
@ServerEndpoint("/websocket")
public class MessController extends BaseController {

    private static ChatdetailMapper chatdetailMapper;

    private static ChatroomMapper chatroomMapper;

    private static Chatroomservice chatroomservice;

    private static UserMapper userMapper;

    @Autowired
    public void setChatdetailMapper(ChatdetailMapper chatdetailMapper) {
        com.example.waimai.controller.MessController.chatdetailMapper = chatdetailMapper;
    }

    @Autowired
    public void setChatroomservice(Chatroomservice chatroomservice) {
        com.example.waimai.controller.MessController.chatroomservice = chatroomservice;
    }

    @Autowired
    public void setChatroomDao(ChatroomMapper chatroomMapper) {
        com.example.waimai.controller.MessController.chatroomMapper = chatroomMapper;
    }

    @Autowired
    public void setUserDao(UserMapper userMapper) {
        com.example.waimai.controller.MessController.userMapper = userMapper;
    }

    private static int onlineCount = 0;

    private static CopyOnWriteArraySet<com.example.waimai.controller.MessController> webSocketSet = new CopyOnWriteArraySet<>();

    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();
        System.out.println("有新连接接入！当前在线人数为"+ getOnlineCount());
        try {
            sendMessage("进入消息队列");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("有一连接关闭！当前在线人数为"+ getOnlineCount());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws JSONException {
        System.out.println(message);
        JSONObject json = new JSONObject(message);
        Chatdetail chatdetail1 = new Chatdetail();
        chatdetail1.setUserid(returnJSONObjectString(json, "userid"));
        chatdetail1.setTouserid(returnJSONObjectString(json, "touserid"));
        chatdetail1.setContent(returnJSONObjectString(json, "content"));
        chatdetail1.setOrderid(returnJSONObjectString(json, "orderid"));
        chatdetail1.setSpeaker("customer");
        chatdetailMapper.save(chatdetail1.getUserid(),chatdetail1.getTouserid(),chatdetail1.getContent(),chatdetail1.getSpeaker(),chatdetail1.getOrderid());
        Chatdetail chatdetail2 = new Chatdetail();
        chatdetail2.setUserid(returnJSONObjectString(json, "touserid"));
        chatdetail2.setTouserid(returnJSONObjectString(json, "userid"));
        chatdetail2.setContent(returnJSONObjectString(json, "content"));
        chatdetail2.setOrderid(returnJSONObjectString(json, "orderid"));
        chatdetail2.setSpeaker("server");
        chatdetailMapper.save(chatdetail2.getUserid(),chatdetail2.getTouserid(),chatdetail2.getContent(),chatdetail2.getSpeaker(),chatdetail2.getOrderid());
//        if (chatroomMapper.findByUseridAndTouserid(returnJSONObjectString(json, "userid"), returnJSONObjectString(json, "touserid")) == null && chatroomMapper.findByUseridAndTouserid(returnJSONObjectString(json, "touserid"), returnJSONObjectString(json, "userid")) == null) {
//            Chatroom chatroom1 = new Chatroom();
//            chatroom1.setUserid(returnJSONObjectString(json, "userid"));
//            System.out.println(returnJSONObjectString(json, "userid"));
//            User user1 = userMapper.findByuserid(returnJSONObjectString(json, "userid")).get(1);
//            chatroom1.setUserimg(user1.getAvatarUrl());
//            User user2 = userMapper.findByuserid(returnJSONObjectString(json, "touserid")).get(1);
//            chatroom1.setTouserimg(user2.getAvatarUrl());
//            chatroom1.setTousernickname(user2.getNickName());
//            chatroom1.setTouserid(returnJSONObjectString(json, "touserid"));
//            chatroom1.setLastcontent(returnJSONObjectString(json, "content"));
//            chatroom1.setLasttime(returnJSONObjectString(json, "lasttime"));
//            chatroomMapper.save(chatroom1.getUserid(),chatroom1.getUserimg(),chatroom1.getTouserimg(),chatroom1.getTousernickname(),chatroom1.getTouserid(),chatroom1.getLastcontent(),chatroom1.getLasttime());
//            Chatroom chatroom2 = new Chatroom();
//            chatroom2.setUserid(returnJSONObjectString(json, "touserid"));
//            User user3 = userMapper.findByuserid(returnJSONObjectString(json, "touserid")).get(1);
//            chatroom2.setUserimg(user3.getAvatarUrl());
//            User user4 = userMapper.findByuserid(returnJSONObjectString(json, "userid")).get(1);
//            chatroom2.setTouserimg(user4.getAvatarUrl());
//            chatroom2.setTousernickname(user4.getNickName());
//            chatroom2.setTouserid(returnJSONObjectString(json, "userid"));
//            chatroom2.setLastcontent(returnJSONObjectString(json, "content"));
//            chatroom2.setLasttime(returnJSONObjectString(json, "lasttime"));
//            chatroomMapper.save(chatroom2.getUserid(),chatroom2.getUserimg(),chatroom2.getTouserimg(),chatroom2.getTousernickname(),chatroom2.getTouserid(),chatroom2.getLastcontent(),chatroom2.getLasttime());
//        } else {
            Chatroom chatroom5 = chatroomMapper.selectByorderid(returnJSONObjectString(json, "orderid"),returnJSONObjectString(json, "userid"),returnJSONObjectString(json, "touserid"));
            chatroom5.setLastcontent(returnJSONObjectString(json, "content"));
            chatroom5.setLasttime(returnJSONObjectString(json, "lasttime"));
            chatroom5.setUserid(returnJSONObjectString(json, "userid"));
            chatroom5.setTouserid(returnJSONObjectString(json, "touserid"));
            chatroom5.setOrderid(returnJSONObjectString(json, "orderid"));
            chatroomservice.update(chatroom5.getLasttime(),chatroom5.getLastcontent(),chatroom5.getUserid(),chatroom5.getTouserid(),chatroom5.getOrderid());
            Chatroom chatroom6 = chatroomMapper.selectByorderid(returnJSONObjectString(json, "orderid"),returnJSONObjectString(json, "touserid"),returnJSONObjectString(json, "userid"));
            chatroom6.setLastcontent(returnJSONObjectString(json, "content"));
            chatroom6.setLasttime(returnJSONObjectString(json, "lasttime"));
            chatroom6.setUserid(returnJSONObjectString(json, "touserid"));
            chatroom6.setTouserid(returnJSONObjectString(json, "userid"));
            chatroom6.setOrderid(returnJSONObjectString(json, "orderid"));
            chatroomservice.update(chatroom6.getLasttime(),chatroom6.getLastcontent(),chatroom6.getUserid(),chatroom6.getTouserid(),chatroom6.getOrderid());
//        }



        for (com.example.waimai.controller.MessController item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
                error.printStackTrace();
    }

    public void sendMessage(String message) throws IOException {
        this.session.getAsyncRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        onlineCount--;
    }
}
