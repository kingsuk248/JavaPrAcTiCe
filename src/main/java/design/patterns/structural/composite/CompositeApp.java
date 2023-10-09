package design.patterns.structural.composite;

public class CompositeApp {
    public static void main(String[] args) {
        Drawing drawing = new Drawing();
        drawing.addShape(new Circle());
        drawing.addShape(new Triangle());

        drawing.fillColor("red");

    }
}
