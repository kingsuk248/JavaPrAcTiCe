package concurrency;

public class ThreadedApp1 {
    public static void main(String[] args) throws InterruptedException {
        ThreadedApp1 app = new ThreadedApp1();
        //app.testThreadStopping();
        app.testThreadJoin();
    }

    private void testThreadStopping() throws InterruptedException {
        StoppableThread st = new StoppableThread();
        Thread t1 = new Thread(st, "StoppableThread");
        t1.start();
        Thread.sleep(2000);
        st.stopIt();
        System.out.println("Done Execution !");
    }

    public static class StoppableThread implements Runnable {
        private boolean stop = false;

        public synchronized void stopIt() {
            stop = true;
        }

        @Override
        public void run() {
            while (!stop) {
                System.out.println(Thread.currentThread().getName() + " is still running");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void testThreadJoin() throws InterruptedException {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + ": started running");
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName() + ": still running");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t1 = new Thread(runnable, "JoinedThread");
        t1.start();
        t1.join();
        System.out.println("Done Execution of testThreadJoin !!!");
    }
}
