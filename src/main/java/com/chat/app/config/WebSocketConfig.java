package com.chat.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")
            .setAllowedOrigins("http://localhost:8080")
            .withSockJS();   //add compatibility to client who doesn't support websockts 
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); //handle messages for topics -- 
        registry.setApplicationDestinationPrefixes("/app");
    }
    
    
}


/*
 * WebSocket -IT provide continous two way communication channel open between client (front end Appliction ) and server
 * STOMP - It gives structure to communication that we do & define how will be messages are rounted & defined
 * MessageBroking - way of rounting message & it is middle man who direct the message to the right place
 */