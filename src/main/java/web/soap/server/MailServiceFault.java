
package web.soap.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MailServiceFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MailServiceFault">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serviceFaultInfo" type="{http://server.soap.web/}serviceFaultInfo" minOccurs="0"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MailServiceFault", propOrder = {
    "serviceFaultInfo",
    "message"
})
public class MailServiceFault {

    protected ServiceFaultInfo serviceFaultInfo;
    protected String message;

    /**
     * Gets the value of the serviceFaultInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceFaultInfo }
     *     
     */
    public ServiceFaultInfo getServiceFaultInfo() {
        return serviceFaultInfo;
    }

    /**
     * Sets the value of the serviceFaultInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceFaultInfo }
     *     
     */
    public void setServiceFaultInfo(ServiceFaultInfo value) {
        this.serviceFaultInfo = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

}
