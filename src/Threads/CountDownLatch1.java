package Threads;

import java.util.concurrent.CountDownLatch;

public class CountDownLatch1 {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(4);
    }
}

class WorkerThreads extends Thread {
    private int delay;
    private CountDownLatch latch;

    //const
    public WorkerThreads(String name,int delay, CountDownLatch latch) {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            System.out.println(Thread.currentThread().getName()+ " çalışıyor");
            latch.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}