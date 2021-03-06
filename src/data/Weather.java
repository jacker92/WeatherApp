package data;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Weather {

    private Document doc;
    private HashMap<String, String> map;

    public Weather(String content) throws SAXException, IOException, ParserConfigurationException {

        map = new HashMap<>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            doc = dBuilder.parse(new InputSource(new StringReader(content)));
            doc.getDocumentElement().normalize();
            parseCurrentData();
    }

    private void parseCurrentData() {
        NodeList nodes = doc.getElementsByTagName("current");
            Node node = nodes.item(0);
            Element e = (Element) node;

            map.put("weather", getValue("weather", e, "value"));
            map.put("temperature", getValue("temperature", e, "max"));
            map.put("windSpeed", getValue("speed", e, "value"));
    }

    private String getValue(String tag, Element e, String attr) {
        return ((Element) e.getElementsByTagName(tag).item(0)).getAttribute(attr);
    }

    public HashMap<String, String> getMap() {
        return map;
    }

}
