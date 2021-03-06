package application;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//Allows to work with XML files
public class XmlHandler {
	
	public static String getLabel(Document doc, String name) {
		NodeList list = doc.getElementsByTagName(name);
		return (list.getLength() != 0) ? list.item(0).getTextContent() : "[MISSING LABEL]";
	}
	
	public static Document loadXMLDocument(String fileName) throws ParserConfigurationException, SAXException, IOException {
		Document doc = null;
		
		DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		doc = dBuilder.parse(new File("XML/" + fileName));
		doc.getDocumentElement().normalize();
		
		return doc;
	}
	
	public static void changeSelectorValue(String selector, String value, Document doc, String fileName) {
		try {
			Node node = doc.getElementsByTagName(selector).item(0);
			node.setTextContent(value);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("XML/"+fileName));
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
