//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.04.12 at 06:37:34 PM SGT 
//


package com.sysgrate.client.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OWCampaigns complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OWCampaigns"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CampaignList" type="{http://datatypes.outboundwebservices.ccmm.applications.nortel.com}ArrayOfOWCampaign" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OWCampaigns", propOrder = {
    "campaignList"
})
public class OWCampaigns {

    @XmlElement(name = "CampaignList")
    protected ArrayOfOWCampaign campaignList;

    /**
     * Gets the value of the campaignList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfOWCampaign }
     *     
     */
    public ArrayOfOWCampaign getCampaignList() {
        return campaignList;
    }

    /**
     * Sets the value of the campaignList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfOWCampaign }
     *     
     */
    public void setCampaignList(ArrayOfOWCampaign value) {
        this.campaignList = value;
    }

}