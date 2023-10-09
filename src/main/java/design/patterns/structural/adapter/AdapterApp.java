package design.patterns.structural.adapter;

public class AdapterApp {
    public static void main(String[] args) {
        ISocketAdapter socketAdapter1 = new SocketClassAdapterImpl();
        Volt v3_1 = socketAdapter1.get3Volts();
        Volt v12_1 = socketAdapter1.get12Volts();
        Volt v120_1 = socketAdapter1.get120Volts();

        ISocketAdapter socketAdapter2 = new SocketObjectAdapterImpl();
        Volt v3_2 = socketAdapter2.get3Volts();
        Volt v12_2 = socketAdapter2.get12Volts();
        Volt v120_2 = socketAdapter2.get120Volts();

        System.out.println(v3_1.getVoltage());
        System.out.println(v3_2.getVoltage());
        System.out.println(v12_1.getVoltage());
        System.out.println(v12_2.getVoltage());
        System.out.println(v120_1.getVoltage());
        System.out.println(v120_2.getVoltage());

    }
}
