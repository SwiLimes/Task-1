package items;

import enums.*;

public class Brick extends Item {
    public Brick(String name, double weight, Shape shape) {
        super(name, weight, shape);
    }

    public static Brick createDefaultBrick() {
        return new Brick("Brick", 10, Shape.SQUARE);
    }

}
