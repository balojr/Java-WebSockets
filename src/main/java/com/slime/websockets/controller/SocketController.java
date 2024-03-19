package com.slime.websockets.controller;

import com.slime.websockets.domain.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class SocketController {

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public Message message() {
        return new Message("fromUser", "Hello, World!", "toUser" + HtmlUtils.htmlEscape("recipient"));
    }
}
