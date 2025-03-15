package com.chat.app.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.chat.app.model.ChatMessage;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage setMessage(ChatMessage message){
        return message;
    }
    
    @GetMapping("chat")
    public String chat(){
        return "chat";
    }
}



/*
 * Responsible for handling all incoming messages from front-End and broadcast to client
 */