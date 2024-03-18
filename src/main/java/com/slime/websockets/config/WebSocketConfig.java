package com.slime.websockets.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Configuration class for WebSocket.
 * Enables WebSocket message broker and provides configuration methods.
 * This class extends AbstractWebSocketMessageBrokerConfigurer to provide custom configuration for the WebSocket.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /**
     * Configures the message broker.
     * Enables a simple broker and sets application destination prefixes.
     * The "/topic" prefix is used by the broker to carry messages back to the client.
     * The "/app" prefix is used to filter destinations targeting application annotated methods (via @MessageMapping).
     *
     * @param config the MessageBrokerRegistry to configure
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    /**
     * Registers STOMP endpoints.
     * Adds "/chat" as an endpoint and configures it to use SockJS.
     * The "/chat" endpoint, when prefixed with "/app", is the endpoint that the ChatController.send() method is mapped to handle.
     * SockJS fallback options are enabled for this endpoint to allow for graceful degradation to non-WebSocket alternatives when necessary at runtime.
     *
     * @param registry the StompEndpointRegistry to add endpoints to
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat");
        registry.addEndpoint("/chat").withSockJS();
    }
}