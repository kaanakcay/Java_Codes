package com.kaan.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")  // /app/hello üzeridnen ulaşulacak
    @SendTo("/topic/greetings")
    public Greeting greet(HelloMessage message){

        return new Greeting("Hello " + HtmlUtils.htmlEscape(message.getName()));

    }
}
