package design.patterns.structural.adapter;

public class Socket {
    public Volt getVolts() {
        return new Volt(120);
    }
}
