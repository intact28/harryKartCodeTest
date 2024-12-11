
package se.atg.service.harrykart.java.xmlhandling.XmlObjects;

import java.math.BigInteger;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for laneType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="laneType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="integer";
 *       &lt;attribute name="number" type="integer" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "laneType", propOrder = {
    "value"
})
public class LaneType {

    @XmlValue
    protected int value;
    @XmlAttribute(name = "number")
    protected int number;

    /**
     * Gets the value of the value property.
     * 
     * @return int
     *
     *     
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed int
     *     
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return int
     *
     *     
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed int
     *
     *     
     */
    public void setNumber(int value) {
        this.number = value;
    }

}
