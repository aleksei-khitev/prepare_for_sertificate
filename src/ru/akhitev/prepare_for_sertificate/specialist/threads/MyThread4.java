package ru.akhitev.prepare_for_sertificate.specialist.threads;

/**
 * Created by hitev on 04.06.14.
 */
public class MyThread4 implements Runnable {
    private Thread thread;
    private String THREAD_NAME = "Thread-with-Exception";

    public MyThread4(){
        thread = new Thread(this); // Можно было старт реализовать тут же
        thread.setName(THREAD_NAME);
    }

    @Override
    public void run() {
        int n =0;
        for (int i=0; i<130; i++)
            n = 1/i; // Тут будет исключение
    }

    public Thread getThread(){
        return thread;
    }
}
