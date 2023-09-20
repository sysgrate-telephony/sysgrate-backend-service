package com.sysgrate.jtapi.tsapi.modal;

public class SysgrateTelephonyEventResponse {

        private String  msgtype;
        private String  eventtype;
        private String  calling;
        private String  called;
        private String  alerting;
        private String  ucid;
        private String  uui;
        private String  split;

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getEventtype() {
        return eventtype;
    }

    public void setEventtype(String eventtype) {
        this.eventtype = eventtype;
    }

    public String getCalling() {
        return calling;
    }

    public void setCalling(String calling) {
        this.calling = calling;
    }

    public String getCalled() {
        return called;
    }

    public void setCalled(String called) {
        this.called = called;
    }

    public String getAlerting() {
        return alerting;
    }

    public void setAlerting(String alerting) {
        this.alerting = alerting;
    }

    public String getUcid() {
        return ucid;
    }

    public void setUcid(String ucid) {
        this.ucid = ucid;
    }

    public String getUui() {
        return uui;
    }

    public void setUui(String uui) {
        this.uui = uui;
    }

    public String getSplit() {
        return split;
    }

    public void setSplit(String split) {
        this.split = split;
    }


    @Override
    public String toString() {
        return "SysgrateTelephonyEventResponse{" +
                "msgtype='" + msgtype + '\'' +
                ", eventtype='" + eventtype + '\'' +
                ", calling='" + calling + '\'' +
                ", called='" + called + '\'' +
                ", alerting='" + alerting + '\'' +
                ", ucid='" + ucid + '\'' +
                ", uui='" + uui + '\'' +
                ", split='" + split + '\'' +
                '}';
    }
}
