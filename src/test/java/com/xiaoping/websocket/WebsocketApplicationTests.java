package com.xiaoping.websocket;

import com.xiaoping.websocket.mapper.UserMapper;
import com.xiaoping.websocket.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebsocketApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }
    @Test
    void insertUser(){
        User user = new User("xiaoping","123123");
        System.out.println(userMapper.insertUser(user));
    }
    @Test
    void selectUser(){
        System.out.println(userMapper.selectUserByUsername("zs"));
    }

}
