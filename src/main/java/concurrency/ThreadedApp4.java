package concurrency;

public class ThreadedApp4 {
    public static void main(String[] args) throws InterruptedException {
        ThreadedApp4 app = new ThreadedApp4();
        //app.testSynchronizedCase1();
        app.testSynchronizedCase2();
    }

    public void testSynchronizedCase1() throws InterruptedException {
        SynchronizedClass synObj = new SynchronizedClass();
        SynchronizedClass synObj1 = new SynchronizedClass();
        Thread t1 = new Thread(() -> synObj.add(5), "Thread1");
        Thread t2 = new Thread(() -> synObj.subtract(10), "Thread2");
        t1.start();
        t2.start();
        Thread t3 = new Thread(() -> synObj1.add(10), "Thread3");
        t3.start();
        Thread t4 = new Thread(() -> SynchronizedClass.multiply(10), "Thread4");
        t4.start();
        Thread t5 = new Thread(() -> synObj.add(1, 2), "Thread5");
        t5.start();
        Thread.sleep(5000);
        System.out.println("Final value: " + synObj.getValue());
    }

    public void testSynchronizedCase2() throws InterruptedException {
        SynchronizedClass synObj = new SynchronizedClass();
        Thread t1 = new Thread(() -> synObj.doSomething());
        Thread t2 = new Thread(() -> SynchronizedClass.doSomethingElse());
        t1.start();
        t2.start();
        Thread.sleep(3000);
        System.out.println("Done doing something");
    }
}
