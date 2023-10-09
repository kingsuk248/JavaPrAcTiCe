package design.patterns.structural.bridge;

public class RedColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Red color applied");
    }
}
