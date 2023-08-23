package com.example.consumer_server.task;

import com.example.consumer_server.config.WebSocketServer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

@Component
public class Send {

//    @Resource
//    private WebSocketServer webSocketServer;

  //  @Scheduled(fixedDelay = 2000)
    public void sendMsg() throws IOException {
        System.out.println("执行到方法了！！！");
//        webSocketServer.sendAllMessage("hello"+new Date());
    }
}
