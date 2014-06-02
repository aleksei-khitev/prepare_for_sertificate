package ru.akhitev.prepare_for_sertificate.specialist.io;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by hitev on 02.06.14.
 */
public class MainXML {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
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
    }
}
