package ru.akhitev.prepare_for_sertificate.specialist.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author hitev
 */
public class Main {
    public static void main(String[] args) throws IOException
    {
        PersonInfo personInfo = new PersonInfo("Aleksei", 27);
        personInfo.showInfo();
        File file = new File("PersonInfo.ser");
        if( !file.exists() )
            file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    }
}