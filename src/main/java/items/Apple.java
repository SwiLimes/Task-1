package items;

import enums.*;
import writers.SVGWriter;

public class Apple extends Item {

    public Apple(String name, int size, String color) {
        super(name, size, color);
    }

    public static Apple createDefaultApple() {
        return new Apple("Apple", 5, "red");
    }

    @Override
    public int getW() {
        return getSize() * 10;
    }

    @Override
    public int getH() {
        return getSize() * 10;
    }

    @Override
    public void draw(int x, int y, SVGWriter picture) {
        picture.writeEllipse(x + this.getW()/2, y + this.getH()/2, getW()/2, getH()/2, getColor());
        /**getW = 100
         *
         */

    }
}
