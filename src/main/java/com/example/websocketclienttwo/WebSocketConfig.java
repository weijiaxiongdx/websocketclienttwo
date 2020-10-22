package com.example.websocketclienttwo;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class WebSocketConfig {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketConfig.class);

    @Bean
    public WebSocketClient webSocketClient(){

        try {
            WebSocketClient webSocketClient = new WebSocketClient(new URI("ws://localhost:8080/websocket/lisi"),new Draft_6455()) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {
                    logger.info("[websocketclienttwo] 连接成功,数据: {}");
                }

                @Override
                public void onMessage(String message) {
                    logger.info("[websocketclienttwo] 接收到了服务端发送来的消息: {}",message);
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    logger.info("[websocketclienttwo] 客户端退出连接,状态码: {}, 原因: {}",code,reason);
                }

                @Override
                public void onError(Exception ex) {
                    logger.info("[websocketclienttwo] 连接错误: {}",ex);
                }

            };

            webSocketClient.connect();
            return webSocketClient;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
