package com.example.produce_server.controller;

import com.example.produce_server.config.MqttProviderClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/mqtt/provider")
public class MqttProviderController {

    @Resource
    MqttProviderClient mqttProviderClient;

    /**
     * 发送消息
     * @param qos qos
     * @param retained retained
     * @param topic topic
     * @param message message
     * @return 发送结果
     */
    @GetMapping("/sendMessage")
    public String sendMessage(int qos, boolean retained, String topic, String message){
        try {
            mqttProviderClient.publish(qos, retained, topic, message);
            return "发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "发送失败";
        }
    }

}
