package ru.akhitev.prepare_for_sertificate.specialist.threads;

/**
 * Created by hitev on 03.06.14.
 */
public class MyThread3 implements Runnable {
    private Thread thread;
    private String THREAD_NAME = "Daemon-Thread";

    public MyThread3(){
        thread = new Thread(this); // Можно было старт реализовать тут же
        thread.setDaemon(true);
        thread.setName(THREAD_NAME);
    }

    @Override
    public void run() {
        for (int i=0; i<130; i++)
            System.out.printf("Name = %s, i = %d\n", Thread.currentThread().getName(), i);
    }

    public Thread getThread(){
        return thread;
    }
}
