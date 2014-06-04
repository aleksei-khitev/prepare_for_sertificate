package ru.akhitev.prepare_for_sertificate.specialist.threads;

/**
 * Created by hitev on 04.06.14.
 */
public class MyThread5 implements Runnable {
    private Thread thread;
    private String THREAD_NAME = "Thread-for_Interruption";

    public MyThread5(){
        thread = new Thread(this); // Можно было старт реализовать тут же
        thread.setName(THREAD_NAME);
    }

    @Override
    public void run() {
        double d=1.0;
        for (int i=0; i<30; i++){
            for(int j=0; j<1000;j++)
                d=d*d;
        }
    }

    public Thread getThread(){
        return thread;
    }
}
