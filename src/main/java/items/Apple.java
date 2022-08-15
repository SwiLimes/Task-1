package items;

import enums.*;

public class Apple extends Item {
    public Apple(String name, int size, Shape shape, String color) {
        super(name, size, shape, color);
    }

    public Apple createDefaultApple() {
        return new Apple("Apple", 2, Shape.SQUARE, "orange");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
