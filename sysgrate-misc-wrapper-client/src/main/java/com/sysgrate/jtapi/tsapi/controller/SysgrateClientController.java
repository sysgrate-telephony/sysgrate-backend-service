package com.sysgrate.jtapi.tsapi.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sysgrate.jtapi.tsapi.config.SysgrateConfiguration;
import com.sysgrate.jtapi.tsapi.modal.ClientData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysgrateClientController {


	@Autowired
	SysgrateConfiguration sysgrateConfiguration;


	@RequestMapping(value="/v1/getData/",
			method= RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public String getData(@org.springframework.web.bind.annotation.RequestBody ClientData data) throws UnirestException {
		Logger logger = LogManager.getLogger(SysgrateClientController.class);
		try {

			logger.debug("The client data is : " + data);
			Unirest
					.setTimeouts(0, 0);
			HttpResponse<String> response = Unirest.post(sysgrateConfiguration.getUrl())
					.header("accept", "application/json")
					.header("Content-Type", "application/x-www-form-urlencoded")
					.field("client_secret", sysgrateConfiguration.getSecret())
					.field("code_verifier", data.getVerifier())
					.field("redirect_uri", data.getRedirect())
					.field("code", data.getCode())
					.field("client_id", data.getId())
					.field("scope", data.getScope())
					.field("refresh_token", data.getRefreshToken())
					.field("device_code", data.getDeviceCode())
					.field("grant_type", data.getGrantType())
					.asString();

			logger.debug("The client response is : " + response.getBody());
			return response.getBody();
		}catch(Exception e){
			logger.error("The client returned error response : " + e.getMessage());
			throw e;

		}

	}

}
