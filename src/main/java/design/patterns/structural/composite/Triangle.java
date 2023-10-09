package design.patterns.structural.composite;

public class Triangle implements IShape {
    @Override
    public void fillColor(String color) {
        System.out.println("Filling triangle with color: " + color);
    }
}
