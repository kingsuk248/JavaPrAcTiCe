package design.patterns.creational.abstractfactory;

import design.patterns.creational.factory.Computer;

public class ComputerFactory {
    public static Computer getComputer(IComputerAbstractFactory factory) {
        return factory.createComputer();
    }
}
