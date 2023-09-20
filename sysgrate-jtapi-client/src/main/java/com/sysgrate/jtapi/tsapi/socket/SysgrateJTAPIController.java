package com.sysgrate.jtapi.tsapi.socket;

import com.sysgrate.jtapi.tsapi.impl.SysgrateTelephonyImpl;
import com.sysgrate.jtapi.tsapi.modal.AgentName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysgrateJTAPIController {

	@Autowired
	SysgrateTelephonyImpl SysgrateTelephonyImpl;

	@MessageMapping("/sysTelephony")
	@SendTo("/avaya/pullEvents")
	public String subscribe(AgentName terminal) throws Exception {
		//TODO : We can publish msgs to subscribed
		return "You have successfully registered for the sysgrate telephony events.";
	}

	@GetMapping("/healthCheck")
	public String healthCheckAPI() throws Exception {
		return "Service is up";
	}


}
