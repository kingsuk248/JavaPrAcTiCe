package design.patterns.creational.abstractfactory;


import design.patterns.creational.factory.Computer;

public class ComputerFactoryApp {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer(new PCFactory("32gb", "2.4ghz", "500gb"));
        Computer server = ComputerFactory.getComputer(new ServerFactory("256gb", "24.0ghz", "2000tb"));
        System.out.println("PC: " + pc);
        System.out.println("Server: " + server);
    }
}
