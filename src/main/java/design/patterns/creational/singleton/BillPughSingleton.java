package design.patterns.creational.singleton;

public class BillPughSingleton {
    private BillPughSingleton() {};

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    private static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
