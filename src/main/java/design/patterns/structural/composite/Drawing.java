package design.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Drawing implements IShape {
    private final List<IShape> shapes = new ArrayList<>();

    @Override
    public void fillColor(String color) {
        for (IShape shape : shapes) {
            shape.fillColor(color);
        }
    }

    public void addShape(IShape shape) {
        shapes.add(shape);
    }
}
