package design.patterns.creational.factory;

/**
 * This is a Superclass.
 * Can be a Java Class, abstract Class or Interface
 *
 */
public abstract class Computer {
    public abstract String getRAM();
    public abstract String getCPU();
    public abstract String getHDD();

    @Override
    public String toString() {
        return "RAM: " + getRAM() + "; CPU: " + getCPU() + "; HDD: " + getHDD();
    }
}
