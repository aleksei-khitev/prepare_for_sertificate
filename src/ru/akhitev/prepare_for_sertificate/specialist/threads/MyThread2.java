package ru.akhitev.prepare_for_sertificate.specialist.threads;

/**
 * Подход через реализацию интерфейса Runnable
 *
 * Created by hitev on 02.06.14.
 */
public class MyThread2 implements Runnable {
    public Thread thread;

    public MyThread2(){
        thread = new Thread(this); // Можно было старт реализовать тут же
    }

    @Override
    public void run() {
        for (int i=0; i<30; i++)
            System.out.printf("Name = %s, i = %d\n", Thread.currentThread().getName(), i);
    }
}
