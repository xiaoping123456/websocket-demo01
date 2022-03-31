package com.xiaoping.websocket.utils;

import com.xiaoping.websocket.controller.WebSocket;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 统一管理session、websocket、curUser
 */
public class CurPool {

    /**
     * 存放所有的WebSocketServer对象
     */
    public static Map<Integer, WebSocket> websocketServes = new ConcurrentHashMap<>();

    /**
     * list 里面第一个存sessionId，第二个存session
     */
    public static Map<Integer, List<Object>> sessionPool = new ConcurrentHashMap<>();

}
