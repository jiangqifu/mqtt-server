package com.example.consumer_server1.mqtt;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MqttConsumerCallback implements MqttCallback {

    @Value("${spring.mqtt.client.id}")
    private String clientId;

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
