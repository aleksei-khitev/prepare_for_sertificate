package ru.akhitev.prepare_for_sertificate.specialist.threads;

/**
 * Created by hitev on 03.06.14.
 */
public class Main2 {
    public static void main(String[] args) throws Exception{
        MyThread2 myThread2 = new MyThread2(); // Создание потока реализовано в конструкторе.
        myThread2.thread.start(); // start вынесен в main, чтобы видеть, что это поток, а не объект
        myThread2.thread.join(); // Ожидание завершения потока myThread2.thread
        System.out.println("End of main");
    }
}
