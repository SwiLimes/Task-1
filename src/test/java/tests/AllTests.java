package tests;
import static org.junit.jupiter.api.Assertions.*;

import containers.Bag;
import containers.Container;
import items.Apple;
import items.Board;
import items.Brick;
import org.junit.jupiter.api.Test;

public class AllTests {
    @Test
    public void t1() {
        Container testContainer = new Bag();
        testContainer.addItem(Brick.createDefaultBrick());
        testContainer.addItem(Apple.createDefaultApple());
        testContainer.addItem(Board.createDefaultBoard());
        double test = ((Bag)testContainer).getWeight();
        assertEquals(15, test);


    }

    }
