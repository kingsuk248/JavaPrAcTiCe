package concurrency;

public class ThreadedApp3 {
    public static void main(String[] args) throws InterruptedException {
        ThreadedApp3 app = new ThreadedApp3();
        app.testSynchronization();
    }

    int value1 = 0;
    int value2 = 0;
    private final Integer val1 = new Integer(0);
    private final Integer val2 = new Integer(0);

    public void testSynchronization() throws InterruptedException {
        Thread t1 = new Thread(
                () -> incrementValue1(1), "ThreadOne"
        );

        Thread t2 = new Thread(
                () -> incrementValue1(10), "ThreadTwo"
        );

        t1.start();
        t2.start();
        Thread.sleep(3000);
        System.out.println("Value1: " + value1);
        System.out.println("Value2: " + value2);
    }

    private synchronized void incrementValue(int interval) {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.value1 = this.value1 + interval;
        }
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.value2 = this.value2 + interval;
        }

    }

    private void incrementValue1(int interval) {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (val1) {
                this.value1 = this.value1 + interval;
            }
        }
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (val2) {
                this.value2 = this.value2 + interval;
            }
        }

    }

}
