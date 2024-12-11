
package se.atg.service.harrykart.java.xmlhandling.XmlObjects;


import jakarta.xml.bind.annotation.*;


/**
 * <p>Java class for harryKartType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="harryKartType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="numberOfLoops" type="integer"/&gt;
 *         &lt;element name="startList" type="{}startListType"/&gt;
 *         &lt;element name="powerUps" type="{}powerUpsType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "harryKartType", propOrder = {
    "numberOfLoops",
    "startList",
    "powerUps"
})
@XmlRootElement(name="harryKart")
public class HarryKartType {

    @XmlElement(required = true)
    protected int numberOfLoops;
    @XmlElement(required = true)
    protected StartListType startList;
    @XmlElement(required = true)
    protected PowerUpsType powerUps;

    /**
     * Gets the value of the numberOfLoops property.
     * 
     * @return int
     *
     *     
     */
    public int getNumberOfLoops() {
        return numberOfLoops;
    }

    /**
     * Sets the value of the numberOfLoops property.
     * 
     * @param value
     *     allowed int
     *
     *     
     */
    public void setNumberOfLoops(int value) {
        this.numberOfLoops = value;
    }

    /**
     * Gets the value of the startList property.
     * 
     * @return
     *     possible object is
     *     {@link StartListType }
     *     
     */
    public StartListType getStartList() {
        return startList;
    }

    /**
     * Sets the value of the startList property.
     * 
     * @param value
     *     allowed object is
     *     {@link StartListType }
     *     
     */
    public void setStartList(StartListType value) {
        this.startList = value;
    }

    /**
     * Gets the value of the powerUps property.
     * 
     * @return
     *     possible object is
     *     {@link PowerUpsType }
     *     
     */
    public PowerUpsType getPowerUps() {
        return powerUps;
    }

    /**
     * Sets the value of the powerUps property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerUpsType }
     *     
     */
    public void setPowerUps(PowerUpsType value) {
        this.powerUps = value;
    }

}
