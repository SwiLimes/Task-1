package items;

import enums.*;

public class Board extends Item {

    public Board(String name, double weight, int size, Shape shape) {
        super(name, weight, size, shape);
    }

    public Board createDefaultBoard() {
        return new Board("Board", 5, 5, Shape.FLAT);
    }
}
