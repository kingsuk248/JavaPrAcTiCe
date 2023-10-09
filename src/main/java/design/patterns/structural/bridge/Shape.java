package design.patterns.structural.bridge;

public abstract class Shape {
    final Color color;

    Shape(Color color) {
        this.color = color;
    }

    public abstract void applyColor();
}
