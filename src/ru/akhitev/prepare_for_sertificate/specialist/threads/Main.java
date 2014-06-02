package ru.akhitev.prepare_for_sertificate.specialist.threads;

/**
 * Created by hitev on 02.06.14.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        final MyThread1 myThread1 = new MyThread1(); // Классический подход
        MyThread2 myThread2 = new MyThread2(); // Создание потока реализовано в конструкторе.
        System.out.printf("myThread1 демон? : %s; myThread2 демон? : %s\n",myThread1.isDaemon(), myThread2.thread.isDaemon());
        myThread1.start();
        myThread2.thread.start(); // start вынесен в main, чтобы видеть, что это поток, а не объект

        System.out.println("End of main");
    }
}
