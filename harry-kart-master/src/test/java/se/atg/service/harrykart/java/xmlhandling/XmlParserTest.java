package se.atg.service.harrykart.java.xmlhandling;

import org.junit.jupiter.api.Test;
import se.atg.service.harrykart.java.xmlhandling.XmlObjects.HarryKartType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class XmlParserTest {

    @Test
    void getHarryKart_successfulParsing() {
        XmlParser parser = new XmlParser();
        String validXml = readFileToString("input_0.xml");  // Replace with valid XML data
        HarryKartType result = parser.getHarryKart(validXml);
        assertNotNull(result);
        assertEquals(3, result.getNumberOfLoops());  // Adjust expected values accordingly
    }

    @Test
    void getHarryKart_invalidXml() {
        XmlParser parser = new XmlParser();
        String invalidXml = readFileToString("input_invalid_xml.xml");
        Exception exception = assertThrows(RuntimeException.class, () -> {
            parser.getHarryKart(invalidXml);
        });
        assertEquals("Invalid XML", exception.getMessage());
    }

    @Test
    void getHarryKart_invalidRaceData() {
        XmlParser parser = new XmlParser();
        String invalidRaceDataXml = readFileToString("input_invalid_racedata.xml");  // Replace with XML containing invalid race data
        Exception exception = assertThrows(RuntimeException.class, () -> {
            parser.getHarryKart(invalidRaceDataXml);
        });
        assertEquals("Invalid Race Data", exception.getMessage());
    }

    /**
     *
     * @param filename XML filename to be read from /resources
     * @return
     */
    private String readFileToString(String filename) {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(filename);
        Objects.requireNonNull(in);
        String xmlString = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            xmlString = br.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
            return xmlString;
        }
        return xmlString;
    }
}