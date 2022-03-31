package com.xiaoping.websocket.controller;

import com.alibaba.fastjson.JSONObject;
import com.xiaoping.websocket.mapper.UserMapper;
import com.xiaoping.websocket.model.User;
import com.xiaoping.websocket.utils.CurPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.Session;
import java.io.IOException;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/register")
    public Object register(@RequestBody User user){
        JSONObject res = new JSONObject();
        userMapper.insertUser(user);
        res.put("code",1);
        return res;
    }

    @RequestMapping("/login")
    public Object login(@RequestBody User user){
        JSONObject res = new JSONObject();
        User userForBase = userMapper.selectUserByUsername(user.getUsername());
        if (userForBase==null || !userForBase.getPassword().equals(user.getPassword())){
            res.put("code",0);
        }else{
            res.put("code",1);
            res.put("user",userForBase);
        }
        return res;
    }

    @RequestMapping("/sendMessage")
    public Object sendMessage(@RequestBody String json){
        JSONObject params = JSONObject.parseObject(json);
        Integer userId = params.getInteger("userId");
        Session session = (Session) CurPool.sessionPool.get(userId).get(1);
        if (session!=null){
            try {
                session.getBasicRemote().sendText("这是服务端发送来的消息");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        JSONObject res = new JSONObject();
        res.put("code",1);

        return res;
    }

}
