package design.patterns.creational.singleton;

/**
 * Singleton instance is created at the time of class loading inside static block
 */
public class StaticBlockSingleton {
    private StaticBlockSingleton() {}
    private static final StaticBlockSingleton instance;

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception ex) {
            throw new RuntimeException("Error when creating the singleton object");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
