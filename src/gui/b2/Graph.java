package gui.b2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

enum ShapeType {
    SQUARE, RECTANGLE, CIRCLE, POLYGON
}

class ShapeInfo {
    ShapeType type;
    Color color;
    boolean filled;
    int x, y, width, height;
    int[] xPoints, yPoints;

    ShapeInfo(ShapeType type, Color color, boolean filled, int x, int y, int width, int height) {
        this.type = type;
        this.color = color;
        this.filled = filled;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    ShapeInfo(ShapeType type, Color color, boolean filled, int[] xPoints, int[] yPoints) {
        this.type = type;
        this.color = color;
        this.filled = filled;
        this.xPoints = xPoints;
        this.yPoints = yPoints;
    }
}

public class Graph extends JFrame {
    private ShapeType selectedShape = ShapeType.SQUARE;
    private Color selectedColor = Color.BLACK;
    private boolean isFilled = false;
    private List<ShapeInfo> shapes = new ArrayList<>();

    public Graph() {
        setTitle("Shape Drawing Application");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel controlPanel = new JPanel();
        JComboBox<String> shapeSelector = new JComboBox<>(new String[]{"Square", "Rectangle", "Circle", "Polygon"});
        JCheckBox fillCheckbox = new JCheckBox("Filled");
        JButton colorButton = new JButton("Choose Color");
        colorButton.setBackground(selectedColor);

        shapeSelector.addActionListener(e -> {
            switch (shapeSelector.getSelectedIndex()) {
                case 0 -> selectedShape = ShapeType.SQUARE;
                case 1 -> selectedShape = ShapeType.RECTANGLE;
                case 2 -> selectedShape = ShapeType.CIRCLE;
                case 3 -> selectedShape = ShapeType.POLYGON;
            }
        });

        fillCheckbox.addActionListener(e -> isFilled = fillCheckbox.isSelected());

        colorButton.addActionListener(e -> {
            selectedColor = JColorChooser.showDialog(null, "Choose Shape Color", selectedColor);
            colorButton.setBackground(selectedColor);
        });

        controlPanel.add(new JLabel("Shape:"));
        controlPanel.add(shapeSelector);
        controlPanel.add(fillCheckbox);
        controlPanel.add(colorButton);
        add(controlPanel, BorderLayout.NORTH);

        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (ShapeInfo shape : shapes) {
                    g.setColor(shape.color);
                    switch (shape.type) {
                        case SQUARE, RECTANGLE -> {
                            if (shape.filled) g.fillRect(shape.x, shape.y, shape.width, shape.height);
                            else g.drawRect(shape.x, shape.y, shape.width, shape.height);
                        }
                        case CIRCLE -> {
                            if (shape.filled) g.fillOval(shape.x, shape.y, shape.width, shape.width);
                            else g.drawOval(shape.x, shape.y, shape.width, shape.width);
                        }
                        case POLYGON -> {
                            if (shape.filled) g.fillPolygon(shape.xPoints, shape.yPoints, shape.xPoints.length);
                            else g.drawPolygon(shape.xPoints, shape.yPoints, shape.xPoints.length);
                        }
                    }
                }
            }
        };

        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                ShapeInfo shape = null;

                switch (selectedShape) {
                    case SQUARE -> shape = new ShapeInfo(ShapeType.SQUARE, selectedColor, isFilled, x, y, 50, 50);
                    case RECTANGLE -> shape = new ShapeInfo(ShapeType.RECTANGLE, selectedColor, isFilled, x, y, 80, 50);
                    case CIRCLE -> shape = new ShapeInfo(ShapeType.CIRCLE, selectedColor, isFilled, x, y, 50, 50);
                    case POLYGON -> {
                        int[] xPoints = {x, x + 40, x + 20};
                        int[] yPoints = {y, y, y + 40};
                        shape = new ShapeInfo(ShapeType.POLYGON, selectedColor, isFilled, xPoints, yPoints);
                    }
                }

                if (shape != null) {
                    shapes.add(shape);
                    drawingPanel.repaint();
                }
            }
        });

        add(drawingPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Graph app = new Graph();
        app.setVisible(true);
    }
}
