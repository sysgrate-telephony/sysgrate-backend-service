package com.sysgrate.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sysgrate.client.AvayaClient;
import com.sysgrate.client.SysgrateProperties;
import com.sysgrate.client.model.AppendContactsToCampaign;
import com.sysgrate.client.model.AppendContactsToCampaignResponse;
import com.sysgrate.client.model.OWContact;
import com.sysgrate.client.model.OWPhoneNumber;
import com.sysgrate.client.model.OutboundLogin;
import com.sysgrate.client.model.OutboundLoginResponse;
import com.sysgrate.client.model.OutboundLogoff;
import com.sysgrate.client.model.OutboundLogoffResponse;
import com.sysgrate.model.AppendData;


@RestController
public class SoapAccessResource {
	
	@Autowired
	AvayaClient client;
	

	private static String sessionKey;

	private static final Logger logger = LoggerFactory.getLogger(SoapAccessResource.class);


	private static final String accs_ip="http://10.5.75.51";
	
	
	@PostMapping("/campaign")
	public AppendContactsToCampaignResponse appendCampaignDetails(@RequestBody AppendData campaign) throws Exception {
		logger.info("Starting the appendCampaignDetails ()");

		if(null==sessionKey) {
			logger.info("session key is not available attempting to login");
			OutboundLogin  login=new OutboundLogin();
			login.setPassword("Avaya@123");
			login.setUsername("cbadmin");
			sessionKey=loginlogoutInternal(login);
		}
		logger.info("session key is available continue with the request creation");
		AppendContactsToCampaign campaigns=new AppendContactsToCampaign();
		OWContact contact = new OWContact();
		contact.setContactID(0);
		OWPhoneNumber number=new OWPhoneNumber();
		number.setPhoneNo(campaign.getP());
		contact.setSkillsetID(campaign.getS());
		contact.setPhoneNumber(number);
		campaigns.setContact(contact);
		campaigns.setSessionKey(sessionKey);
		campaigns.setCampaignID(campaign.getC());

		ObjectMapper objectMapper =new ObjectMapper();

		logger.info("Request to the appendCampaignDetails() : " + objectMapper.writeValueAsString(campaigns) );

		AppendContactsToCampaignResponse response=  client.getCampaignsResponse(accs_ip+"/ccmmoutboundwebservices/OutboundCampaignWS.asmx", campaigns);
		logger.info("Response from the appendCampaignDetails() : " + response.getAppendContactsToCampaignResult());
		return response;

	}
	
	@PostMapping("/login")
	public OutboundLoginResponse login(@RequestBody OutboundLogin login) {
		return  client.login(accs_ip+"/ccmmoutboundwebservices/OutboundUtilityWS.asmx", login);
	}
	
	@PostMapping("/logout")
	public OutboundLogoffResponse logout(@RequestBody OutboundLogoff logoff) {
		
		return  client.logoff(accs_ip+"/ccmmoutboundwebservices/OutboundUtilityWS.asmx", logoff);
	}
	
	
	public String loginlogoutInternal(OutboundLogin login) throws Exception {
		int count=0;
		logger.info("logging in to obtain the session key");
		while(count<3) {
			try {
				String sessionKey= client.login(accs_ip + "/ccmmoutboundwebservices/OutboundUtilityWS.asmx", login).getOutboundLoginResult();
				logger.info("Obtained the session key successfully");
				return sessionKey;
			} catch (Exception e) {
				if (e.getMessage().contains("An Application administrator with user ID cbadmin is already logged in") || e.getMessage().contains("Expired")) {
					OutboundLogoff logoff = new OutboundLogoff();
					logoff.setUsername("cbadmin");
					try {
						client.logoff(accs_ip + "/ccmmoutboundwebservices/OutboundUtilityWS.asmx", logoff);
					}
					catch(Exception e1){
						logger.warn("There was a trouble logging out the existing session. Trying again.");
					}
				}
              count++;
			}
		}
		logger.error("There was a trouble obtaining the session key . Please check the logs for more details.");
		throw new Exception("There was a trouble obtaining the session key . Please check the logs for more details.");
	}

}
