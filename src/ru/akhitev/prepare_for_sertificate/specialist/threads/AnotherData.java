package ru.akhitev.prepare_for_sertificate.specialist.threads;

/**
 * Created by hitev on 19.06.14.
 */
public class AnotherData {
    private int state=1;

    public int getState(){
        return state;
    }

    public void Tic(){
        System.out.println("Tic-");
        state=2;
    }

    public void Tak(){
        System.out.println("Tak");
        state=1;
    }
}
