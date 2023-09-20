package com.sysgrate.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class SysgrateProperties {
    
    private String webservice;

	public String getWebservice() {
		return webservice;
	}

	public void setWebservice(String webservice) {
		this.webservice = webservice;
	}

    
    
}
