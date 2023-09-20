package com.sysgrate.client;

import java.io.IOException;
import java.util.Base64;

import javax.xml.soap.MimeHeaders;
import javax.xml.transform.TransformerException;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

public class SoapRequestHeaderModifierLogout implements WebServiceMessageCallback {
	
	 @Override
	 public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
	  if (message instanceof SaajSoapMessage) {
	   SaajSoapMessage soapMessage = (SaajSoapMessage) message;
	   MimeHeaders mimeHeader = soapMessage.getSaajMessage().getMimeHeaders();
	   mimeHeader.setHeader("SOAPAction","http://nortel.com/CCMMOutboundWebservices/OutboundLogoff");
	  }
	 }

}
	


