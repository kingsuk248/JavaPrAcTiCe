package design.patterns.structural.adapter;

public class Volt {
    private int voltage;

    public Volt(int volts) {
        this.voltage = volts;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int volts) {
        this.voltage = volts;
    }
}
