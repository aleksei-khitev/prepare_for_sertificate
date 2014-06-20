package ru.akhitev.prepare_for_sertificate.specialist.threads;

/**
 * Created by hitev on 19.06.14.
 */
public class Main7 {
    public static void main(String[] args) throws InterruptedException {
        AnotherData d = new AnotherData();
        Worker1 w1 = new Worker1(1,d);
        Worker2 w2 = new Worker2(2,d);
        w2.join();
        System.out.println("end of main...");
    }
}
