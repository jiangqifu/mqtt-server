package com.example.consumer_server.controller;

import com.example.consumer_server.config.MqttConsumerClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/mqtt/consumer")
public class MqttConsumerController {

    @Resource
    private MqttConsumerClient mqttConsumerClient;

    @Value("${spring.mqtt.client.id}")
    private String clientId;

    @RequestMapping("/connect")
    public String connect(){
        mqttConsumerClient.connect();
        return clientId + "连接到服务器";
    }

    @RequestMapping("/disConnect")
    public String disConnect(){
        mqttConsumerClient.disConnect();
        return clientId + "与服务器断开连接";
    }

}
