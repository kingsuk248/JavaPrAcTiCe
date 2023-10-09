package design.patterns.structural.adapter;

public class SocketObjectAdapterImpl implements ISocketAdapter{
    Socket socket = new Socket();

    @Override
    public Volt get120Volts() {
        return socket.getVolts();
    }

    @Override
    public Volt get12Volts() {
        Volt v = socket.getVolts();
        return convertVolt(v.getVoltage(), 10);
    }

    @Override
    public Volt get3Volts() {
        Volt v = socket.getVolts();
        return convertVolt(v.getVoltage(), 40);
    }

    private Volt convertVolt(int volts, int factor) {
        return new Volt(volts/factor);
    }
}
