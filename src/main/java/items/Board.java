package items;

import enums.*;
import writers.SVGWriter;

public class Board extends Item {

    public Board(String name, int size, double weight, String color) {
        super(name, size, weight, Shape.FLAT, color);
    }

    public static Board createDefaultBoard() {
        return new Board("Board", 5, 5, "green");
    }

    @Override
    public int getW() {
        return getSize() * 20;
    }

    @Override
    public int getH() {
        return getSize() * 20;
    }

    @Override
    public void draw(int x, int y, SVGWriter picture) {
        picture.writeRect(x, y, getW(), getH(), getColor());
    }
}
