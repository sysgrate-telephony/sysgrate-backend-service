package com.sysgrate.jtapi.tsapi.modal;

import java.io.Serializable;

public class ClientData implements Serializable {
    
    private String secret;
		private String verifier;
		private String redirect;
		private String code;
		private String id;
		private String scope;
		private String refreshToken;
		private String deviceCode;
		private String grantType;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    @Override
    public String toString() {
        return "ClientData{" +
                "secret='" + secret + '\'' +
                ", verifier='" + verifier + '\'' +
                ", redirect='" + redirect + '\'' +
                ", code='" + code + '\'' +
                ", id='" + id + '\'' +
                ", scope='" + scope + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", deviceCode='" + deviceCode + '\'' +
                ", grantType='" + grantType + '\'' +
                '}';
    }
}
