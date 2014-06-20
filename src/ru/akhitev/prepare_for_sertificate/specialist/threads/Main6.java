package ru.akhitev.prepare_for_sertificate.specialist.threads;

/**
 * Created by hitev on 19.06.14.
 */
public class Main6 extends Thread{
    private boolean suspended = false; // приостановлен
    private boolean terminated = false; // закончен

    public Main6(){
        suspended = false;
        terminated = false;
    }

    public Main6(boolean susp){
        suspended=susp;
        terminated=false;
    }

    public void terminate(){
        terminated = true;
    }

    public void my_resume(){
        if(suspended){
            suspended=false;
            synchronized (this){
                notify();
            }
            System.out.println("go...");
        }
    }

    public boolean is_suspended(){
        return suspended;
    }

    public void my_suspend(){
        if(!suspended)
            suspended=true;
    }

    public boolean is_suspend(){
        return suspended;
    }

    @Override
    public void run(){
        int count = 0;
        try{
            // Проверка флага. Если флаг завершения true - закончить работу
            while(!terminated){
                synchronized (this){
                    // Проверка флага. Если будет вызван notify, снова будет проверка флага. Если true - дальше wait
                    while(suspended) wait();
                }
                System.out.printf("Count = %d\n", count++);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        Main6 thr = new Main6();
        thr.start();

        for(int i=0; i<3; i++){
            Thread.sleep(1000);
            if(thr.is_suspend())
                thr.my_resume();
            else
                thr.my_suspend();
        }
        thr.my_resume();
        thr.terminate();
        thr.join();
    }
}
