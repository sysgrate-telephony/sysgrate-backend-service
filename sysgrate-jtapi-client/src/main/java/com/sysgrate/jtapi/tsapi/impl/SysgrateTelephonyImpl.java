package com.sysgrate.jtapi.tsapi.impl;

import com.sysgrate.jtapi.tsapi.config.SysgrateConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.telephony.*;

@Component
public class SysgrateTelephonyImpl  implements ProviderListener {
	private JtapiPeer jtapiPeer = null;
	private Provider provider;

	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;

	@Autowired
	SysgrateConfiguration sysgrateConfiguration;
	/**
	 * This method creates the default JtapiPeer.
	 */


	Logger logger = LogManager.getLogger(SysgrateTelephonyImpl.class);

	@PostConstruct
	public void initJtapi() {
		try {
			// get default implementation of the JtapiPeer object by sending null optionally you may send com.avaya.jtapi.tsapi.TsapiPeer
			jtapiPeer = JtapiPeerFactory.getJtapiPeer(null);
			logger.info("JtapiPeer created successfully.\n\n");
		} catch (JtapiPeerUnavailableException e) {
			try {
				jtapiPeer = JtapiPeerFactory
						.getJtapiPeer("com.avaya.jtapi.tsapi.TsapiPeer");
				logger.info("JtapiPeer created successfully.\n\n");
			} catch (JtapiPeerUnavailableException e2) {
				logger.error("JtapiPeerFactory.getJtapiPeer: caught "
						+ "JtapiPeerUnavailableException\n");
				logger.error("Message: " + e2.getMessage() + "\n\n");
				logger.error("Error: JtapiPeer could not be created.  "
						+ "Verify your Jtapi client install.\n\n");
			}
		}
		login();
	}

	/**
	 * This method creates the Provider and waits until is in service.
	 */
	public synchronized void login() {
		String serviceName;
		String login;
		String password;
		String providerString;

		serviceName = sysgrateConfiguration.getTlink();
		login = sysgrateConfiguration.getUsername();
		password = sysgrateConfiguration.getPassword();

		providerString = serviceName + ";loginID=" + login + ";passwd="
				+ password;

		logger.info("Provider String is :" +providerString);

		if (jtapiPeer == null) {
			return;
		}

		try {
			// create provider
			provider = jtapiPeer.getProvider(providerString);
			logger.info("Provider created successfully.\n\n");
			logger.info("Waiting for the provider to initialize...\n");

			// add a ProviderListener to the provider
			provider.addProviderListener(this);

		} catch (Exception e) {
			logger.error("login() caught " + e + "\n");
			logger.error("Message: " + e.getMessage() + "\n\n");
			logger.error("Please verify that the login information is correct.\n\n");
			System.exit(1);
		}
		System.out.println("Provider is in service.\n\n");
		try {
			try {
				// In order to make a call, we need to obtain an Address and a
				// Terminal
				// object that represent the dialing extension. In Avaya's
				// implementation
				// of JTAPI, there is a one-to-one relationship between the
				// Terminal and
				// Address objects that represent an extension number.
				// create Address

				String [] terminals=sysgrateConfiguration.getTerminals().split(",");
				for (String terminal:terminals) {

					Terminal myTerminal = provider.getTerminal(terminal);
					myTerminal.getName();
					logger.info("Terminal " + myTerminal.getName() + " created successfully.\n\n");
					myTerminal.addCallListener(new SysgrateTelephonyListener(terminal,simpMessagingTemplate));

				}
			} catch (Exception e) {
				logger.error("Please verify that the dialing extension number is correct.\n\n");
				throw (e);
			}

		} catch (Exception e) {
			logger.error("login() caught " + e + "\n");
			logger.error("Message: " + e.getMessage() + "\n\n");
		}
	}

	@Override
	public void providerInService(ProviderEvent providerEvent) {

	}

	@Override
	public void providerEventTransmissionEnded(ProviderEvent providerEvent) {

	}

	@Override
	public void providerOutOfService(ProviderEvent providerEvent) {

	}

	@Override
	public void providerShutdown(ProviderEvent providerEvent) {
		logger.info("Provider is shutting down , we are trying to keep it alive.");
		if(jtapiPeer==null){
			initJtapi();
		}
		login();
		logger.info("Provider has been restored");
	}

}
