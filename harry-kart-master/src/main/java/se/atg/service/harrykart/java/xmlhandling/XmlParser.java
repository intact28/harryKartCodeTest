package se.atg.service.harrykart.java.xmlhandling;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.xml.sax.SAXException;
import se.atg.service.harrykart.java.xmlhandling.XmlObjects.HarryKartType;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

public class XmlParser {

    public HarryKartType getHarryKart(String xmlString){
        HarryKartType harryKartType;
        JAXBContext jaxbContext;
        if(verifyXml(xmlString)) {
            try {
                jaxbContext = JAXBContext.newInstance(HarryKartType.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                harryKartType = (HarryKartType) jaxbUnmarshaller.unmarshal(new StringReader(xmlString));
            } catch (JAXBException e) {
                throw new RuntimeException("Failed to deserialize XML", e);
            }
            if(verifyRaceData(harryKartType)) {
                return harryKartType;
            }
            else {
                throw new RuntimeException("Invalid Race Data");
            }
        } else {
            throw new RuntimeException("Invalid XML");
        }
    }

    private boolean verifyXml(String xmlString) {
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("src/main/resources/input.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new StringReader(xmlString)));
        } catch (IOException | SAXException e) {
            return false;
        }
        return true;
    }

    private boolean verifyRaceData(HarryKartType raceData){
        return raceData.getNumberOfLoops() == raceData.getPowerUps().getLoop().size()+1;

    }

}
