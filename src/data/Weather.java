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

    public Weather(String content) {
        System.out.println(content);

        map = new HashMap<>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            doc = dBuilder.parse(new InputSource(new StringReader(content)));

            doc.getDocumentElement().normalize();
            parseCurrentData();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
          
        }

    }

    private void parseCurrentData() {

        NodeList nodes = doc.getElementsByTagName("current");

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            Element e = (Element) node;

            map.put("weather", getValue("weather", e, "value"));
            map.put("temperature", getValue("temperature", e, "max"));
            
        }
    }

    private String getValue(String tag, Element e, String attr) {

        return ((Element) e.getElementsByTagName(tag).item(0)).getAttribute(attr);
    }

    public HashMap<String, String> getMap() {
        return map;
    }

}
