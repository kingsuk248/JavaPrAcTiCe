package design.patterns.structural.adapter;

public class SocketClassAdapterImpl extends Socket implements ISocketAdapter {
    @Override
    public Volt get120Volts() {
        return super.getVolts();
    }

    @Override
    public Volt get12Volts() {
        Volt v = super.getVolts();
        return convertVolt(v.getVoltage(), 10);
    }

    @Override
    public Volt get3Volts() {
        Volt v = super.getVolts();
        return convertVolt(v.getVoltage(), 40);
    }

    private Volt convertVolt(int volts, int factor) {
        return new Volt(volts/factor);
    }
}
