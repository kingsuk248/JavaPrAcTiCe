package concurrency;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ThreadedApp5 {
    public static void main(String[] args) {
        ThreadedApp5 app = new ThreadedApp5();
        app.testSynchronizedLambda();
    }

    public void testSynchronizedLambda() {
        Consumer<String> consumerFunc = (String var1) -> {
            synchronized (ThreadedApp5.class) {
                String threadName = Thread.currentThread().getName();
                System.out.println("Thread: " + threadName + " has var: " + var1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread: " + threadName + " still has var: " + var1);
            }
        };
        Thread t1 = new Thread(() -> consumerFunc.accept("something"));
        Thread t2 = new Thread(() -> consumerFunc.accept("something else"));
        t1.start();
        t2.start();
    }
}
