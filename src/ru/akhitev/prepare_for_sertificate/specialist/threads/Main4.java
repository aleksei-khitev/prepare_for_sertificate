package ru.akhitev.prepare_for_sertificate.specialist.threads;

import java.util.Random;

/**
 * Created by hitev on 18.06.14.
 */
public class Main4 {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue(){
            return new Random().nextInt(100);
        }
    };

    public static void main(String[] args) {
        threadLocal.set(new Random().nextInt(100));
        Runnable runnable = new Runnable(){
            public void run(){
                threadLocal.set(new Random().nextInt(100));
                System.out.printf("Thread %s, value is %d\n", Thread.currentThread().getName(),threadLocal.get());
            }
        };
        for(int i=0;i<3;i++)
            (new Thread(runnable)).start();
        System.out.printf("Main Thread value is %d\n",threadLocal.get());
    }
}
