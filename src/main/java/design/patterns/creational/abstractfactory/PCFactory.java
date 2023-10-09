package design.patterns.creational.abstractfactory;

import design.patterns.creational.factory.Computer;
import design.patterns.creational.factory.PC;

public class PCFactory implements IComputerAbstractFactory {
    private String ram;
    private String cpu;
    private String hdd;

    public PCFactory(String ram, String cpu, String hdd) {
        this.ram = ram;
        this.cpu = cpu;
        this.hdd = hdd;
    }
    @Override
    public Computer createComputer() {
        return new PC(this.ram, this.cpu, this.hdd);
    }
}
