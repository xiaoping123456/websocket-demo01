package com.xiaoping.websocket.controller;

import com.xiaoping.websocket.utils.CurPool;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@ServerEndpoint("/websocket/{userId}")
public class WebSocket {

    private Session session;

    @OnOpen
    public void onOpen(Session session, @PathParam("userId")Integer userId){
        this.session=session;
        // 把新的websocket对象存入对象池中
        CurPool.websocketServes.put(userId,this);
        List<Object> list = new ArrayList<>();
        list.add(userId);
        list.add(session);
        CurPool.sessionPool.put(userId,list);
        System.out.println("websocket 有新的连接，现在总数为："+CurPool.websocketServes.size());
        System.out.println("sessionPool 总数："+CurPool.sessionPool.size());
        System.out.println("-----");
    }

    @OnClose
    public void onClose(){
        System.out.println("webSocket断开连接");
    }

    @OnMessage
    public void OnMessage(String message){
        System.out.println("收到对方发送的消息："+message);
    }

}
