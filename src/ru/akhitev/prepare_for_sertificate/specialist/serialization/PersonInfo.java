package ru.akhitev.prepare_for_sertificate.specialist.serialization;

import java.io.Serializable;

/**
 *
 * @author hitev
 */
public class PersonInfo implements Serializable{
    transient String name;
    int age;

    public PersonInfo(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void showInfo()
    {
        System.out.printf("Name: %s Age: %d\n", this.name, this.age);
    }
}
