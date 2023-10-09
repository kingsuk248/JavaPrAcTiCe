package design.patterns.structural.flyweight;

import java.awt.*;

public class Line implements Shape {

    public Line() throws InterruptedException {
        System.out.println("Creating a line...");
        Thread.sleep(2000);
    }

    @Override
    public void draw(Graphics line, int x, int y, int width, int height, Color color) {
        line.setColor(color);
        line.drawLine(x, y, width, height);
    }
}
