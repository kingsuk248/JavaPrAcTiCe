package design.patterns.structural.flyweight;

import javax.swing.*;
import design.patterns.structural.flyweight.ShapeFactory.ShapeType;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingClient extends JFrame {
    private static final long serialVersionUID = -1350200437285282550L;
    private final int WIDTH;
    private final int HEIGHT;

    private static final ShapeType[] shapes = {ShapeType.LINE, ShapeType.OVAL_FILL, ShapeType.OVAL_NO_FILL};
    private static final Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};

    public DrawingClient(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        Container container = getContentPane();
        JButton startButton = new JButton("start");
        JPanel panel = new JPanel();
        container.add(panel, BorderLayout.CENTER);
        container.add(startButton, BorderLayout.SOUTH);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Graphics g = panel.getGraphics();
                for (int i = 0; i < 10; i++) {
                    int randShape = (int)(Math.random() * shapes.length);
                    int randColor = (int)(Math.random() * colors.length);
                    int randX = (int)(Math.random() * WIDTH);
                    int randY = (int)(Math.random() * HEIGHT);
                    int randW = (int)(Math.random() * WIDTH / 10);
                    int randH = (int)(Math.random() * HEIGHT / 10);
                    try {
                        Shape shape = ShapeFactory.getShape(shapes[randShape]);
                        shape.draw(g, randX, randY, randW, randH, colors[randColor]);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        DrawingClient client = new DrawingClient(500, 500);
    }
}
