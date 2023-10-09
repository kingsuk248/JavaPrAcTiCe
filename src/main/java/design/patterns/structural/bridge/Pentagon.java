package design.patterns.structural.bridge;

public class Pentagon extends Shape{

    public Pentagon(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.println("Pentagon colored....");
        color.applyColor();
    }
}
