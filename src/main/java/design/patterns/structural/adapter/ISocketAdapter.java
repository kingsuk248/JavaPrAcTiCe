package design.patterns.structural.adapter;

public interface ISocketAdapter {
    public Volt get120Volts();
    public Volt get12Volts();
    public Volt get3Volts();
}
