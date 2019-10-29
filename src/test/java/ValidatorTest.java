import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.xml.transform.stream.StreamSource;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ValidatorTest {

    @DisplayName("Check for non existing documents")
    @ParameterizedTest
    @ValueSource(strings = {"empty.xml xsd_valid.xsd xslt_scheme.xslt rr.xml"})
    void checkNonExistingDocuments(String parametrs) {
        ArgsParser parser = new ArgsParser(parametrs.split(" "));
        XmlCheck xmlCheck = new XmlCheck(parser);
        assertFalse(xmlCheck.documentExistCheck());
    }

    @DisplayName("Check failed Validation of Source XML")
    @ParameterizedTest
    @ValueSource(strings = {"notvalid.xml xsd_valid.xsd xslt_scheme.xslt rr.xml"})
    void checkNotValid(String parametrs) {
        ArgsParser parser = new ArgsParser(parametrs.split(" "));
        XmlCheck xmlCheck = new XmlCheck(parser);
        assertFalse(xmlCheck.validateXsd(new StreamSource(new File(parser.getRes("SourceXml")))));
    }

    @DisplayName("Check correct Validation of Source XML")
    @ParameterizedTest
    @ValueSource(strings = {"src/test/resources/xml_example.xml src/test/resources/xsd_valid.xsd xslt_scheme.xslt rr.xml"})
    void checkValid(String parametrs) {
        ArgsParser parser = new ArgsParser(parametrs.split(" "));
        XmlCheck xmlCheck = new XmlCheck(parser);
        assertTrue(xmlCheck.validateXsd(new StreamSource(new File(parser.getRes("SourceXml")))));
    }

    @DisplayName("Check correct Validation of Source XML")
    @ParameterizedTest
    @ValueSource(strings = {"src/test/resources/xml_example.xml src/test/resources/xsd_valid.xsd xslt_scheme.xslt rr.xml"})
    void checkTransform() {
        //TODO ТЕСТ ТРАНСФОРМЕРА КАРЧОЕ
    }
}
