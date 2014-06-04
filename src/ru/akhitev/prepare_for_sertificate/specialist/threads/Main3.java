package ru.akhitev.prepare_for_sertificate.specialist.threads;

/**
 * Created by hitev on 04.06.14.
 */
public class Main3 {
    public static void main(String[] args) throws Exception{
        MyThread5 myThread5 = new MyThread5(); // Создание потока реализовано в конструкторе.
        myThread5.getThread().start(); // start вынесен в main, чтобы видеть, что это поток, а не объект
        Thread.sleep(1000); // приостановить текущий поток
        myThread5.getThread().interrupt(); // завершить поток
        System.out.println("End of main");
    }
}
