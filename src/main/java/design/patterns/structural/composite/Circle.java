package design.patterns.structural.composite;

public class Circle implements IShape {
    @Override
    public void fillColor(String color) {
        System.out.println("Filling circle with color: " + color);
    }
}
