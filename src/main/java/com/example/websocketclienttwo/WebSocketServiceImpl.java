package com.example.websocketclienttwo;

import org.java_websocket.client.WebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebSocketServiceImpl implements WebSocketService {

    @Autowired
    WebSocketClient webSocketClient;

    @Override
    public void sendMsg(String msg) {
        webSocketClient.send(msg);
    }

    @Override
    public void close() {
        webSocketClient.close();
    }

    @Override
    public void open() {
        webSocketClient.connect();
    }
}
