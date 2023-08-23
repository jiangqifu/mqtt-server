package com.example.consumer_server.mqtt;

import com.example.consumer_server.config.WebSocketServer;
import com.example.consumer_server.task.Send;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Slf4j
@Component
public class MqttConsumerCallback implements MqttCallback {

    @Value("${spring.mqtt.client.id}")
    private String clientId;

    @Resource
    private Send send;

    /**
     * 断开连接回调
     */
    @Override
    public void connectionLost(Throwable throwable) {
        log.error(clientId + "与服务器断开连接...");
    }

    /**
     * 监听消息回调
     */
    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {

        log.info("webSocket:开始执行了");
        WebSocketServer webSocketServer=new WebSocketServer();
        webSocketServer.sendAllMessage(new String(mqttMessage.getPayload()));
        log.info("webSocket:执行结束了");
        log.info("接收消息主题：{}", topic);
        log.info("接收消息Qos：{}", mqttMessage.getQos());
        log.info("接收消息内容：{}", new String(mqttMessage.getPayload()));
        log.info("接收消息retained：{}", mqttMessage.isRetained());
    }

    /**
     * 发送消息完成回调
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
