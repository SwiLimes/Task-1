package tests;

import static org.junit.jupiter.api.Assertions.*;

import containers.Bag;
import containers.Container;
import containers.Stack;
import enums.Shape;
import items.Apple;
import items.Board;
import items.Brick;
import items.Item;
import org.junit.jupiter.api.Test;

public class AllTests {
    @Test
    public void t1() {
        Container testContainer = new Bag();
        testContainer.addItem(Brick.createDefaultBrick());
        testContainer.addItem(Apple.createDefaultApple());
        testContainer.addItem(Board.createDefaultBoard());
        double test = ((Bag) testContainer).getWeight();
        assertEquals(15, test);
    }

    @Test
    public void t2() {
        Container testStack = new Stack();
        testStack.addItem(Board.createDefaultBoard());
        testStack.addItem(Board.createDefaultBoard());
        testStack.addItem(new Board("Second", 15, 5, Shape.FLAT));

        ((Stack) testStack).showStack();
        assertEquals(testStack.takeItem(), Board.createDefaultBoard());

        System.out.println("\n\n\n");
        ((Stack) testStack).showStack();

    }

}
