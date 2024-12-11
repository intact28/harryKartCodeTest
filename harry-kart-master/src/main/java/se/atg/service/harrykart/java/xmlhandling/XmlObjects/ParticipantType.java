
package se.atg.service.harrykart.java.xmlhandling.XmlObjects;

import java.math.BigInteger;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for participantType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="participantType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lane" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="baseSpeed" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "participantType", propOrder = {
    "lane",
    "name",
    "baseSpeed"
})
public class ParticipantType {

    @XmlElement(required = true)
    protected int lane;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected int baseSpeed;

    /**
     * Gets the value of the lane property.
     * 
     * @return int
     *
     *     
     */
    public int getLane() {
        return lane;
    }

    /**
     * Sets the value of the lane property.
     * 
     * @param value
     *     Allowed int
     *     
     */
    public void setLane(int value) {
        this.lane = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the baseSpeed property.
     * 
     * @return int
     *
     *     
     */
    public int getBaseSpeed() {
        return baseSpeed;
    }

    /**
     * Sets the value of the baseSpeed property.
     * 
     * @param value
     *     allowed int
     *     
     */
    public void setBaseSpeed(int value) {
        this.baseSpeed = value;
    }

}
