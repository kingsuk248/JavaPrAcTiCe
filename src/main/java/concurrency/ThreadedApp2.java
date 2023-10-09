package concurrency;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to simulate race conditions and critical sections
 */
public class ThreadedApp2 {
    public static void main(String[] args) throws InterruptedException {
        ThreadedApp2 app = new ThreadedApp2();
        app.simulateRaceCondition1();
        app.simulateRaceCondition2();
    }

    public void simulateRaceCondition1() throws InterruptedException {
        Counter counter = new Counter();

        // Simulate read-modify-write race condition
        Thread t1 = new Thread(
                () -> {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("Initial counter value: " + counter.value + " for: " + threadName);
                    for (int i = 0; i < 5; i++) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        counter.add(1);
                    }
                    System.out.println("Final counter value: " + counter.value + " for: " + threadName);
                }, "ThreadOne"
        );

        Thread t2 = new Thread(
                () -> {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("Initial counter value: " + counter.value + " for: " + threadName);
                    for (int i = 0; i < 5; i++) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        counter.add(2);
                    }
                    System.out.println("Final counter value: " + counter.value + " for: " + threadName);
                }, "ThreadTwo"
        );

        t1.start();
        t2.start();
        Thread.sleep(5000);
        String threadName = Thread.currentThread().getName();
        System.out.println("Final counter value: " + counter.value + " for: " + threadName);
    }

    public static class Counter {
        long value = 0;

        void add(long value) {
            this.value = this.value + value;
        }
    }

    public void simulateRaceCondition2() throws InterruptedException {
        Map<String, Integer> sampleMap = new HashMap<>();
        sampleMap.put("abc", 123);
        sampleMap.put("xyz", 246);

        // Simulate check-then-act race condition
        Thread t1 = new Thread(
                () -> replaceKey(sampleMap, 11235), "ThreadOne"
        );

        Thread t2 = new Thread(
                () -> replaceKey(sampleMap, 10101), "ThreadTwo"
        );

        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println(sampleMap);

    }

    private void replaceKey(Map<String, Integer> sampleMap, int value) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (sampleMap.containsKey("abc")) {
            sampleMap.remove("abc");
        } else {
            sampleMap.put("abc", value);
        }
    }
}
