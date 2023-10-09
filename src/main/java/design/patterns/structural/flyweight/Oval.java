package design.patterns.structural.flyweight;

import java.awt.*;

public class Oval implements Shape {
    private final boolean fill;

    public Oval(boolean f) throws InterruptedException {
        System.out.println("Creating a oval with fill: " + f);
        Thread.sleep(2000);
        fill = f;
    }

    @Override
    public void draw(Graphics oval, int x, int y, int width, int height, Color color) {
        oval.setColor(color);
        oval.drawOval(x, y, width, height);
        if (this.fill) {
            oval.fillOval(x, y, width, height);
        }
    }
}
