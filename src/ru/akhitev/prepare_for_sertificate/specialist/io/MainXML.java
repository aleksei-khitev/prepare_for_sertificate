package ru.akhitev.prepare_for_sertificate.specialist.io;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by hitev on 02.06.14.
 */
public class MainXML {
    public static void main(String[] args) throws IOException, XMLStreamException, ParserConfigurationException, SAXException {
        // С помощью XMLStreamReader/XMLStreamWriter
        XMLOutputFactory factory = XMLOutputFactory.newFactory(); // Получили фабрику, вызвав статический метод
        XMLStreamWriter writer = factory.createXMLStreamWriter(
                new FileOutputStream("test.xml"), "utf-8"
        );
        writer.writeStartDocument();
        writer.writeStartElement("testElement");
        writer.writeCharacters("test contains");
        writer.writeEndElement();
        writer.writeEndDocument();
        writer.close();

        // Через объектную модель
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(
                new FileInputStream("books.xml")
        );
        NodeList nodeList = document.getElementsByTagName("book");
        for(int i = 0; i< nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            System.out.println(
                    node.getAttributes().getNamedItem("price").getNodeValue()
            );
            System.out.println(
                    node.getFirstChild().getNodeValue().trim()
            );
        }
    }
}
