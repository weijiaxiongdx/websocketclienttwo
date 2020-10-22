package com.example.websocketclienttwo;

public interface WebSocketService {

    void sendMsg(String msg);

    void close();

    void open();
}
