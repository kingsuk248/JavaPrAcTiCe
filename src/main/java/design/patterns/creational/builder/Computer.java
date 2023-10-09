package design.patterns.creational.builder;

public class Computer {

    // required variables
    private String ram;
    private String cpu;
    private String hdd;

    // optional variables
    private boolean hasGraphicsCard;
    private boolean hasBluetooth;

    public String getRam() {
        return ram;
    }

    public String getCpu() {
        return cpu;
    }

    public String getHdd() {
        return hdd;
    }

    public boolean isHasGraphicsCard() {
        return hasGraphicsCard;
    }

    public boolean isHasBluetooth() {
        return hasBluetooth;
    }

    private Computer(ComputerBuilder builder) {
        this.ram = builder.ram;
        this.cpu = builder.cpu;
        this.hdd = builder.hdd;
        this.hasGraphicsCard = builder.hasGraphicsCard;
        this.hasBluetooth = builder.hasBluetooth;
    }

    @Override
    public String toString() {
        return "RAM: " + this.getRam() + "; CPU: " + this.getCpu()
                + "; HDD: " + this.getHdd() + "; Graphics: " + this.isHasGraphicsCard()
                + "; Bluetooth: " + this.isHasBluetooth();
    }

    public static class ComputerBuilder {
        // required variables
        private String ram;
        private String cpu;
        private String hdd;

        // optional variables
        private boolean hasGraphicsCard;
        private boolean hasBluetooth;

        public ComputerBuilder(String ram, String cpu, String hdd) {
            this.ram = ram;
            this.cpu = cpu;
            this.hdd = hdd;
        }

        public ComputerBuilder setGraphicsCard(boolean hasGraphicsCard) {
            this.hasGraphicsCard = hasGraphicsCard;
            return this;
        }

        public ComputerBuilder setBluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
