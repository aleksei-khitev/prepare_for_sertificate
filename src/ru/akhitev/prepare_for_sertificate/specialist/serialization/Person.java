package ru.akhitev.prepare_for_sertificate.specialist.serialization;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;

public class Person implements Externalizable {
    private static final short MAGIC = 0x0155;
    private static final String CHARSET = "KOI8-R";
    transient public String name;
    transient public String lastName;
    transient public int age;

    public Person(String lastName, String name, int age){
        super();
        this.lastName=lastName;
        this.name=name;
        this.age=age;
    }

    public void showInfo(){
        System.out.printf("Last name: %s First name: %s Age: %d\n", lastName, name, age);
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeShort(MAGIC);
        objectOutput.writeInt(this.name.length());
        byte[] nameBytes = name.getBytes(CHARSET);
        objectOutput.write(nameBytes);
        objectOutput.writeInt(this.lastName.length());
        nameBytes = lastName.getBytes(CHARSET);
        objectOutput.write(nameBytes);
        objectOutput.writeInt(this.age);
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        short magic = objectInput.readShort();
        if(magic != MAGIC)
            throw new ClassNotFoundException();
        int len = objectInput.readInt();
        byte[] bytes = new byte[len];
        objectInput.read(bytes, 0, len);
        this.name = new String(bytes, CHARSET);
        len = objectInput.readInt();
        bytes = new byte[len];
        objectInput.read(bytes, 0, len);
        this.lastName = new String(bytes, CHARSET);
        this.age=objectInput.readInt();
    }

    public void writeXml(OutputStream outputStream){
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer;
        try{
            writer = outputFactory.createXMLStreamWriter(outputStream, "utf-8");
            writer.writeStartDocument("utf-8", "1.0");
            writer.writeStartElement("person");
            writer.writeStartElement("lastName");
            writer.writeCharacters(this.lastName);
            writer.writeEndElement();
            writer.writeStartElement("name");
            writer.writeCharacters(this.name);
            writer.writeEndElement();
            writer.writeStartElement("age");
            writer.writeCharacters(String.valueOf(this.age));
            writer.writeEndElement();
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }


}
