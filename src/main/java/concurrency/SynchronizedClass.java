package concurrency;

public class SynchronizedClass {

    private int value;

    public int getValue() {
        return this.value;
    }

    public synchronized void add(int val) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " thread adding");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.value = this.value + val;
    }

    public synchronized void subtract(int val) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " thread subtracting");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.value = this.value - val;
    }

    public static synchronized void multiply(int val) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " thread multiplying");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Will multiply static value (if any)");
    }

    public void add(int val1, int val2) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " thread adding val1 and val2");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.value = val1 + val2;
    }

    public void doSomething() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Doing something by: " + threadName);
        synchronized(this) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Done something by: " + threadName);
        }
    }

    public static void doSomethingElse() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Doing something else by: " + threadName);
        synchronized(SynchronizedClass.class) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Done something else by: " + threadName);
        }
    }

}
