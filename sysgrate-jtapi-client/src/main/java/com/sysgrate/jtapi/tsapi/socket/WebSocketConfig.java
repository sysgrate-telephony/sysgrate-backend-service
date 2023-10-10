package com.sysgrate.jtapi.tsapi.socket;

import com.sysgrate.jtapi.tsapi.config.SysgrateConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Autowired
	SysgrateConfiguration sysgrateConfiguration;

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/avaya");
		config.setApplicationDestinationPrefixes("/sys");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws").setAllowedOrigins(sysgrateConfiguration.getPattern());
		registry.addEndpoint("/ws").setAllowedOrigins(sysgrateConfiguration.getPattern()).withSockJS();
	}

}
