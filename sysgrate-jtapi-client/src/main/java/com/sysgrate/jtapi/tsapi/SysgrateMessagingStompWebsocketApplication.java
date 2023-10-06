package com.sysgrate.jtapi.tsapi;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class SysgrateMessagingStompWebsocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysgrateMessagingStompWebsocketApplication.class, args);
	}

}
