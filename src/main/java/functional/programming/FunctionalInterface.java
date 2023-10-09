package functional.programming;

/**
 * Functional Interface will have max 1 abstract method
 */
public interface FunctionalInterface {
    public void run();

    public default void doSomethingDefault() {
        System.out.println("Default");
    }

    public static void doSomethingStatic() {
        System.out.println("Static");
    }
}
