package design.patterns.creational.factory;

public class ComputerFactoryApp {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer("pc", "32gb", "2.4ghz", "500gb");
        Computer server = ComputerFactory.getComputer("server", "256gb", "20.4ghz", "200tb");
        System.out.println("PC: " + pc);
        System.out.println("Server: " + server);
    }
}
