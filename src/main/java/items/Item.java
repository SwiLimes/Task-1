package items;

import enums.*;

public abstract class Item {
    private String name;
    private double weight;
    private int size;
    private Shape shape;
    private String color;

    //Constructor for class Apple
    public Item(String name, int size, Shape shape, String color) {
        try {
            this.name = name;
            this.size = size;
            this.shape = shape;
            this.color = color;
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            System.out.println("Uncorrected data");
        }
    }

    //Constructor for class Board
    public Item(String name, double weight, int size, Shape shape) {
        try {
            this.name = name;
            this.weight = weight;
            this.size = size;
            this.shape = shape;
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            System.out.println("Uncorrected data");
        }
    }

    //Constructor for class Brick
    public Item(String name, double weight, Shape shape) {
        try {
            this.name = name;
            this.weight = weight;
            this.shape = shape;
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            System.out.println("Uncorrected data");
        }
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
