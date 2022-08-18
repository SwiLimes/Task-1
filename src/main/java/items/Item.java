package items;

import containers.Container;
import enums.*;
import writers.SVGWriter;

public abstract class Item {
    private String name;
    private int size;
    private double weight;
    private Shape shape;
    private String color;
    private boolean isContained = false;

    /**
     * Конструктор Apple
     */
    public Item(String name, int size, String color) {
        this.name = name;
        if (size > 5) throw new IllegalArgumentException("Incorrect size (>5)!");
        this.size = size;
        this.shape = Shape.CIRCLE;
        this.color = color;
    }


    public Item(String name, int size, double weight, Shape shape, String color) {
        this.name = name;
        if(!(this instanceof Container))  {
            if (size > 5)
                throw new IllegalArgumentException("Incorrect size (>5)!");
        }
        this.size = size;
        this.weight = weight;
        this.shape = shape;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getSize() {
        return size;
    }

    public Shape getShape() {
        return shape;
    }

    public String getColor() {
        return color;
    }

    public void setContained(boolean contained) {
        isContained = contained;
    }

    public boolean isContained() {
        return isContained;
    }

    /**
     * Ширина предмета
     */
    public abstract int getW();

    /**
     * Высота предмета
     */
    public abstract int getH();

    public abstract void draw(int x, int y, SVGWriter picture);


    @Override
    public String toString() {
        // Дописать вывод Shape
//        StringBuilder sb = new StringBuilder();
//        if(!this.name.equals("")) sb.append(name + " | ");
//        if(weight != 0) sb.append(weight + " | ");
//        if(size != 0) sb.append(size + " | ");
//        if(shape != null) sb.append(shape.name());


        return String.format("Name: %s | Weight: %f | Size: %d | Shape: %s | Color: %s",
                name, weight, size, shape.name(), color);

    }
}
