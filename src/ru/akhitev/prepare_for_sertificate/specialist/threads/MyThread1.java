package ru.akhitev.prepare_for_sertificate.specialist.threads;

/**
 * Классический подход через наследование
 *
 * Created by hitev on 02.06.14.
 */
public class MyThread1 extends Thread{

    @Override
    public void run(){
        for (int i=0; i<30; i++)
            System.out.printf("Name = %s, i = %d\n", Thread.currentThread().getName(), i);
    }

}
