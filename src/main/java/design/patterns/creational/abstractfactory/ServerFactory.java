package design.patterns.creational.abstractfactory;

import design.patterns.creational.factory.Computer;
import design.patterns.creational.factory.PC;
import design.patterns.creational.factory.Server;

public class ServerFactory implements IComputerAbstractFactory {
    private String ram;
    private String cpu;
    private String hdd;

    public ServerFactory(String ram, String cpu, String hdd) {
        this.ram = ram;
        this.cpu = cpu;
        this.hdd = hdd;
    }

    @Override
    public Computer createComputer() {
        return new Server(this.ram, this.cpu, this.hdd);
    }
}
