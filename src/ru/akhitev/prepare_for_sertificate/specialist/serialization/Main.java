package ru.akhitev.prepare_for_sertificate.specialist.serialization;

import java.io.*;

/**
 *
 * @author hitev
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Создание объекта
        PersonInfo personInfo = new PersonInfo("Aleksei", 27);
        personInfo.showInfo();
        // Подготовка файла
        File file = new File("PersonInfo.ser");
        if( !file.exists() )
            file.createNewFile();
        // Запись объекта в файл
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(personInfo);
        objectOutputStream.close();
        fileOutputStream.close();
        // Чтение объекта из файла
        FileInputStream fileInputStream = new FileInputStream("PersonInfo.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        PersonInfo restorePersonInfo = (PersonInfo)objectInputStream.readObject(); // На выходе object, так что нужно привести тип
        // Проверка объекта
        restorePersonInfo.showInfo();
    }
}