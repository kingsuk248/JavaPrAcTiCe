package design.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
    public static enum ShapeType {
        OVAL_FILL, OVAL_NO_FILL, LINE
    }

    private static final Map<ShapeType, Shape> shapes = new HashMap<>();

    public static Shape getShape(ShapeType shapeType) throws InterruptedException {
        Shape shape = shapes.get(shapeType);
        if (shape == null) {
            if (shapeType.equals(ShapeType.OVAL_FILL)) {
                shape = new Oval(true);
            } else if (shapeType.equals(ShapeType.OVAL_NO_FILL)) {
                shape = new Oval(false);
            } else if (shapeType.equals(ShapeType.LINE)) {
                shape = new Line();
            }
            shapes.put(shapeType, shape);
        }
        return shape;
    }
}
