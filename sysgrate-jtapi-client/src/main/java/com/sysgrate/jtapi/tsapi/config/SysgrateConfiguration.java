package com.sysgrate.jtapi.tsapi.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("sysgrate")
public class SysgrateConfiguration {


    private String tlink;
    private String username;
    private String password;

    private String terminals;

    public String getTlink() {
        return tlink;
    }

    public void setTlink(String tlink) {
        this.tlink = tlink;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTerminals() {
        return terminals;
    }

    public void setTerminals(String terminals) {
        this.terminals = terminals;
    }
}
