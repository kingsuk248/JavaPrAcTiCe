package design.patterns.creational.singleton;

public class ThreadSafeIISingleton {
    private static ThreadSafeIISingleton instance;
    private ThreadSafeIISingleton(){} ;

    public static ThreadSafeIISingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeIISingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeIISingleton();
                }
            }
        }
        return instance;
    }
}
