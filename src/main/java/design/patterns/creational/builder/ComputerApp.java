package design.patterns.creational.builder;

public class ComputerApp {
    public static void main(String[] args) {
        Computer computer1 = new Computer.ComputerBuilder("20gb", "2.4ghz", "500gb").build();
        Computer computer2 = new Computer.ComputerBuilder("20gb", "2.4ghz", "500gb")
                .setGraphicsCard(true)
                .setBluetooth(true)
                .build();
        System.out.println(computer1);
        System.out.println(computer2);
    }
}
