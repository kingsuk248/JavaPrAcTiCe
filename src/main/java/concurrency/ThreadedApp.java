package concurrency;

import javax.crypto.spec.PSource;
import javax.sound.midi.Soundbank;

public class ThreadedApp {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " is running");
        MyThread t1 = new MyThread();
        t1.setName("MyThread");
        t1.start();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running");
                try {
                    Thread.sleep(2000);
                    System.out.println("Anon Woke up !");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        t2.setName("AnonThread");
        t2.start();

        Thread t3 = new Thread(new YetAnotherThread());
        t3.setName("YetAnotherThread");
        t3.start();

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        });
        t4.setName("Thread 4");
        t4.start();

        Thread t5 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " is running"));
        t4.setName("Thread 5");
        t5.start();

        Thread t6 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " is running"),
                "Thread 6");
        t6.start();
        ThreadedApp.spawnMultipleThreads();
    }

    private static void spawnMultipleThreads() {
        System.out.println(Thread.currentThread().getName() + " is running");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println(Thread.currentThread().getName() + " is running"), " " + i)
                    .start();
        }
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running");
            try {
                Thread.sleep(2000);
                System.out.println("MyThread Woke up !");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class YetAnotherThread implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running");
            try {
                Thread.sleep(2000);
                System.out.println("YetAnotherThread Woke up !");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
