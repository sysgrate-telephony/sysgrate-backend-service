package com.sysgrate.jtapi.tsapi.impl;

import com.avaya.jtapi.tsapi.LucentCallInfo;
import com.avaya.jtapi.tsapi.LucentV5CallInfo;
import com.avaya.jtapi.tsapi.UserToUserInfo;
import com.avaya.jtapi.tsapi.adapters.CallControlTerminalConnectionListenerAdapter;
import com.sysgrate.jtapi.tsapi.modal.SysgrateTelephonyEventResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import javax.telephony.Call;
import javax.telephony.TerminalConnectionEvent;
import javax.telephony.callcenter.ACDAddress;
import javax.telephony.callcontrol.CallControlTerminalConnectionEvent;


public class SysgrateTelephonyListener extends CallControlTerminalConnectionListenerAdapter  {
	private String  listenerName = null;

	SysgrateTelephonyListener(String listenerName,SimpMessagingTemplate simpMessagingTemplate){
		this.simpMessagingTemplate=simpMessagingTemplate;
		this.listenerName=listenerName;
	}
	SimpMessagingTemplate simpMessagingTemplate;

	Logger logger= LogManager.getLogger(SysgrateTelephonyListener.class);
	@Override
	public void terminalConnectionRinging(CallControlTerminalConnectionEvent arg0) {


		TerminalConnectionEvent terminalConnectionEvent=arg0;
		if(!terminalConnectionEvent.getTerminalConnection().getTerminal().getName().equals(listenerName)){
			return;
		}
		if(arg0.getCallingAddress()==null){
			logger.debug("Calling address is null - we need this hence we cannot proceed further - flag this.");
			return;
		}
		if(arg0.getCallingAddress().getName().equals(listenerName)){
			return;
		}
		logger.info("terminalConnectionEvent returned"+ terminalConnectionEvent.getTerminalConnection().getTerminal().getName());


		SysgrateTelephonyEventResponse eventResponse=new SysgrateTelephonyEventResponse();
		eventResponse.setMsgtype("Event");
		eventResponse.setEventtype("Ringing");
		eventResponse.setCalling(arg0.getCallingAddress().getName());
		eventResponse.setCalled(arg0.getCalledAddress().getName());

		String terminalMotinored=null;

		Call call =arg0.getCall();
		if ( call instanceof LucentCallInfo) {
			LucentCallInfo lucentCall= (LucentCallInfo) call;
			UserToUserInfo avayaUUI = lucentCall.getUserToUserInfo();
			if ( avayaUUI != null ) {
				String uui = avayaUUI.getString();
				eventResponse.setUui(uui);
			}
			ACDAddress acdAddress=lucentCall.getDeliveringACDAddress();
			if(acdAddress!=null) {
				eventResponse.setSplit(acdAddress.getName());
			}
			if ( call instanceof LucentV5CallInfo) {
				LucentV5CallInfo v5Call = (LucentV5CallInfo) call;
				String ucid = v5Call.getUCID();
				eventResponse.setUcid(ucid);
			}
		}


		logger.info("Event Response is"+eventResponse);
		logger.info("pushing event to end point " + listenerName);
		simpMessagingTemplate.convertAndSend("/avaya/pullEvents/"+listenerName,eventResponse);


	}

	@Override
	public void terminalConnectionTalking(CallControlTerminalConnectionEvent arg0) {

		TerminalConnectionEvent terminalConnectionEvent=arg0;

		if(!terminalConnectionEvent.getTerminalConnection().getTerminal().getName().equals(listenerName)){
			return;
		}
		if(arg0.getCallingAddress().getName().equals(listenerName)){
			return;
		}

		SysgrateTelephonyEventResponse eventResponse=new SysgrateTelephonyEventResponse();
		eventResponse.setMsgtype("Event");
		eventResponse.setEventtype("Talking");
		eventResponse.setCalling(arg0.getCallingAddress().getName());
		eventResponse.setCalled(arg0.getCalledAddress().getName());

		String terminalMotinored=null;

		Call call =arg0.getCall();
		if ( call instanceof LucentCallInfo) {
			LucentCallInfo lucentCall= (LucentCallInfo) call;
			UserToUserInfo avayaUUI = lucentCall.getUserToUserInfo();
			if ( avayaUUI != null ) {
				String uui = avayaUUI.getString();
				eventResponse.setUui(uui);
			}
			ACDAddress acdAddress=lucentCall.getDeliveringACDAddress();
			if(acdAddress!=null) {
				eventResponse.setSplit(acdAddress.getName());
			}
			if ( call instanceof LucentV5CallInfo) {
				LucentV5CallInfo v5Call = (LucentV5CallInfo) call;
				String ucid = v5Call.getUCID();
				eventResponse.setUcid(ucid);
			}
		}


		logger.info("Event Response is"+eventResponse);
		logger.info("pushing event to end point " + listenerName);


		simpMessagingTemplate.convertAndSend("/avaya/pullEvents/"+listenerName,eventResponse);
	}


}
