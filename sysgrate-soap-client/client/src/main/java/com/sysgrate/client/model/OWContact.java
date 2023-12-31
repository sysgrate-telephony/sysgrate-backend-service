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
 * <p>Java class for OWContact complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OWContact"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ContactID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="CampaignName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Address" type="{http://datatypes.outboundwebservices.ccmm.applications.nortel.com}OWAddress" minOccurs="0"/&gt;
 *         &lt;element name="CustomFieldList" type="{http://datatypes.outboundwebservices.ccmm.applications.nortel.com}ArrayOfOWCustomField" minOccurs="0"/&gt;
 *         &lt;element name="EmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PhoneNumber" type="{http://datatypes.outboundwebservices.ccmm.applications.nortel.com}OWPhoneNumber" minOccurs="0"/&gt;
 *         &lt;element name="PreferredAgentID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="PreferredAgentSpecified" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SkillsetID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OWContact", propOrder = {
    "contactID",
    "campaignName",
    "address",
    "customFieldList",
    "emailAddress",
    "firstName",
    "lastName",
    "phoneNumber",
    "preferredAgentID",
    "preferredAgentSpecified",
    "title",
    "skillsetID"
})
public class OWContact {

    @XmlElement(name = "ContactID")
    protected long contactID;
    @XmlElement(name = "CampaignName")
    protected String campaignName;
    @XmlElement(name = "Address")
    protected OWAddress address;
    @XmlElement(name = "CustomFieldList")
    protected ArrayOfOWCustomField customFieldList;
    @XmlElement(name = "EmailAddress")
    protected String emailAddress;
    @XmlElement(name = "FirstName")
    protected String firstName;
    @XmlElement(name = "LastName")
    protected String lastName;
    @XmlElement(name = "PhoneNumber")
    protected OWPhoneNumber phoneNumber;
    @XmlElement(name = "PreferredAgentID")
    protected long preferredAgentID;
    @XmlElement(name = "PreferredAgentSpecified")
    protected boolean preferredAgentSpecified;
    @XmlElement(name = "Title")
    protected String title;
    @XmlElement(name = "SkillsetID")
    protected long skillsetID;

    /**
     * Gets the value of the contactID property.
     * 
     */
    public long getContactID() {
        return contactID;
    }

    /**
     * Sets the value of the contactID property.
     * 
     */
    public void setContactID(long value) {
        this.contactID = value;
    }

    /**
     * Gets the value of the campaignName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampaignName() {
        return campaignName;
    }

    /**
     * Sets the value of the campaignName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampaignName(String value) {
        this.campaignName = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link OWAddress }
     *     
     */
    public OWAddress getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link OWAddress }
     *     
     */
    public void setAddress(OWAddress value) {
        this.address = value;
    }

    /**
     * Gets the value of the customFieldList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfOWCustomField }
     *     
     */
    public ArrayOfOWCustomField getCustomFieldList() {
        return customFieldList;
    }

    /**
     * Sets the value of the customFieldList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfOWCustomField }
     *     
     */
    public void setCustomFieldList(ArrayOfOWCustomField value) {
        this.customFieldList = value;
    }

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link OWPhoneNumber }
     *     
     */
    public OWPhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link OWPhoneNumber }
     *     
     */
    public void setPhoneNumber(OWPhoneNumber value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the value of the preferredAgentID property.
     * 
     */
    public long getPreferredAgentID() {
        return preferredAgentID;
    }

    /**
     * Sets the value of the preferredAgentID property.
     * 
     */
    public void setPreferredAgentID(long value) {
        this.preferredAgentID = value;
    }

    /**
     * Gets the value of the preferredAgentSpecified property.
     * 
     */
    public boolean isPreferredAgentSpecified() {
        return preferredAgentSpecified;
    }

    /**
     * Sets the value of the preferredAgentSpecified property.
     * 
     */
    public void setPreferredAgentSpecified(boolean value) {
        this.preferredAgentSpecified = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the skillsetID property.
     * 
     */
    public long getSkillsetID() {
        return skillsetID;
    }

    /**
     * Sets the value of the skillsetID property.
     * 
     */
    public void setSkillsetID(long value) {
        this.skillsetID = value;
    }

}
