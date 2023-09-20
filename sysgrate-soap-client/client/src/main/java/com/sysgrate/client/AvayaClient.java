package com.sysgrate.client;

import javax.xml.bind.JAXBElement;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.sysgrate.client.model.AppendContactsToCampaignResponse;
import com.sysgrate.client.model.GetCampaignsResponse;
import com.sysgrate.client.model.OutboundLoginResponse;
import com.sysgrate.client.model.OutboundLogoffResponse;

public class AvayaClient extends WebServiceGatewaySupport {
	
	
	public AppendContactsToCampaignResponse getCampaignsResponse(String url, Object request) {
		AppendContactsToCampaignResponse res =  (AppendContactsToCampaignResponse)getWebServiceTemplate().marshalSendAndReceive(url, request,new SoapRequestHeaderModifierAppendData());
		return res;
	}
	
	public OutboundLoginResponse login(String url, Object request) {
		OutboundLoginResponse res =(OutboundLoginResponse) getWebServiceTemplate().marshalSendAndReceive(url, request ,new SoapRequestHeaderModifier());
		return res;
	}
	
	
	public OutboundLogoffResponse logoff(String url, Object request) {
		OutboundLogoffResponse res = (OutboundLogoffResponse) getWebServiceTemplate(). marshalSendAndReceive(url, request , new SoapRequestHeaderModifierLogout());
		return res;
	}
	
}
