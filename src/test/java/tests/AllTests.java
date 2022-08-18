package tests;

import static org.junit.jupiter.api.Assertions.*;

import containers.Bag;
import containers.Box;
import exceptions.ContainerIsEmptyException;
import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;
import exceptions.PlacedInYourself;
import items.Apple;
import items.Board;
import items.Brick;

import items.Item;
import org.junit.jupiter.api.Test;

public class AllTests {


    /**
     * Размер базовых объектов не больше '5'
     */
    @Test
    public void IncorrectItemSize() {
       assertThrows(IllegalArgumentException.class, () -> {
           Apple testApple = new Apple("TestApple", 6, "yellow");
       });


    }

    /**
     * Рассчет веса
     */
    @Test
    public void testGetWeight() {
        Bag bag = Bag.createDefaultBag();
        bag.addItem(Brick.createDefaultBrick());
        bag.addItem(Apple.createDefaultApple());
        bag.addItem(Board.createDefaultBoard());
        double actualWeight = bag.calcWeight(0);
        double exceptedWeight  = bag.getWeight();
        for(Item item : bag.getItems()) {
            exceptedWeight += item.getWeight();
        }
        assertEquals(exceptedWeight, actualWeight);
    }

    @Test
    public void ItemAlreadyPlacedExceptionTest() {
        Apple apple = Apple.createDefaultApple();

        Bag bag = Bag.createDefaultBag();
        bag.addItem(apple);

        Box box = Box.createDefaultBox();

        assertThrows(ItemAlreadyPlacedException.class, () -> {
            box.addItem(apple);
        });
    }


    @Test
    public void ItemStoreExceptionTest() {
        Bag bag = Bag.createDefaultBag();

        assertThrows(ItemStoreException.class, () -> {
            bag.addItem(new Brick("MegaBrick", 5, 150, "black"));
        });
    }

    @Test
    public void ContainerIsEmptyExceptionTest() {
        Box box = Box.createDefaultBox();

        assertThrows(ContainerIsEmptyException.class, ()-> {
            box.takeItem();
        });
    }

    @Test
    public void PlacedInYourselfTest() {
        Box box = Box.createDefaultBox();

        assertThrows(PlacedInYourself.class, () -> {
            box.addItem(box);
        });

    }
}
