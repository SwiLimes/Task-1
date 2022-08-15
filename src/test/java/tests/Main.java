package tests;

import containers.*;
import enums.Shape;
import items.Apple;
import items.Board;
import items.Brick;
import items.Item;


import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Container container = new Bag();
        container.addItem(new Apple("Apple", 5, Shape.CIRCLE, "red"));
        container.addItem(new Board("Board", 15.2, 3, Shape.FLAT));
        container.addItem(new Brick("Brick", 52, Shape.SQUARE));
        container.addItem(new Brick("Brick", 55, Shape.SQUARE));
        container.printItems();


        Item foundedItem = ((Bag)container).searchByName("Apple");
        System.out.println("I found this:\n" + foundedItem);
    }
}
