package ru.akhitev.prepare_for_sertificate.specialist.threads;

/**
 * Created by hitev on 18.06.14.
 */
class Test{
    boolean ready=false;
    synchronized void waitFor(){
        while(!ready) try {
            wait();
        } catch (InterruptedException e) {
            System.out.println("Interrupted...");
        }
    }

    synchronized void goNow(){
        ready = true;
        notify();
    }
}
