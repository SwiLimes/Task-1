package items;

import enums.*;
import writers.SVGWriter;

public class Brick extends Item {
    public Brick(String name, int size, double weight, String color) {
        super(name, size, weight, Shape.SQUARE, color);
    }

    public static Brick createDefaultBrick() {
        return new Brick("Brick", 5,10, "purple");
    }

    @Override
    public int getW() {
        return getSize() * 5;
    }

    @Override
    public int getH() {
        return getSize() * 2;
    }

    @Override
    public void draw(int x, int y, SVGWriter picture) {
        picture.writeRoundRect(x, y, getW(), getH(), 2, 2,  getColor());
    }
}
