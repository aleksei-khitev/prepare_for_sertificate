package ru.akhitev.prepare_for_sertificate.specialist.threads;

/**
 * Created by hitev on 02.06.14.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        final MyThread1 myThread1 = new MyThread1(); // Классический подход
        MyThread2 myThread2 = new MyThread2(); // Создание потока реализовано в конструкторе.
        MyThread3 myThread3 = new MyThread3(); // Демон
        MyThread4 myThread4 = new MyThread4(); // С исключением
        System.out.printf("myThread1 демон? : %s; myThread2 демон? : %s; myThread3 демон? : %s\n"
                ,myThread1.isDaemon(), myThread2.thread.isDaemon(), myThread3.getThread().isDaemon());
        myThread1.start();
        myThread2.thread.start(); // start вынесен в main, чтобы видеть, что это поток, а не объект
        myThread3.getThread().start();
        myThread4.getThread().start();
        System.out.println("End of main");
    }
}