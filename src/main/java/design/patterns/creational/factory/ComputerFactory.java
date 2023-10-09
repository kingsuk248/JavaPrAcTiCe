package design.patterns.creational.factory;

public class ComputerFactory {

    public static Computer getComputer(String name, String ram, String cpu, String hdd) {
        if (name.equalsIgnoreCase("pc")) {
            return new PC(ram, cpu, hdd);
        } else if (name.equalsIgnoreCase("server")) {
            return new Server(ram, cpu, hdd);
        }
        return null;
    }
}
