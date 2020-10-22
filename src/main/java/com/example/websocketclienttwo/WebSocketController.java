package com.example.websocketclienttwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/websocket")
public class WebSocketController {

    @Autowired
    WebSocketService webSocketService;

    @GetMapping("/sendMsg")
    public String sendMsg(@RequestParam(value = "msg") String msg){
        webSocketService.sendMsg(msg);
        return "发送成功";
    }

    @GetMapping("/close")
    public String close(){
        webSocketService.close();
        return "关闭连接成功";
    }

    @GetMapping("/open")
    public String open(){
        webSocketService.open();
        return "连接服务器成功";
    }
}
