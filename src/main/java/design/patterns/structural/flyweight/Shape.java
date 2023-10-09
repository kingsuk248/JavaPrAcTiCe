package design.patterns.structural.flyweight;

import java.awt.*;

public interface Shape {
    void draw(Graphics graphics, int x, int y, int width, int height, Color color);
}
