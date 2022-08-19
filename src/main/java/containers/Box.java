package containers;

import enums.Shape;
import exceptions.ContainerIsEmptyException;
import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;
import items.Item;
import writers.SVGWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Box extends Container {
    public Box(String name, int size, double weight, String color, double maxWeight) {
        super(name, size, weight, Shape.SQUARE, color, new ArrayList<>(), maxWeight);
    }

    public static Box createDefaultBox() {
        return new Box("Box", 50, 15, "aqua", 250);
    }

    @Override
    public double calcWeight(double itemWeight) {
        return super.calcWeight(itemWeight);
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
    public Item takeItem() {
        if (canTakeItem()) return itemsContainer.get(0);
        else throw new ContainerIsEmptyException();
    }

    @Override
    public Item searchItemByName(String name) {
        return null;
    }

    @Override
    public void draw(int x, int y, SVGWriter picture) {
        int w = getW();
        int h = getH();
        /** Отрисовка самого ящики */
        picture.writeRect(x, y, w, h, getColor());

        int currentX = x; //0
        int currentY = y + h;   //500
        int maxRowH = 0;
        if (!canTakeItem()) return;
        for (Item item : itemsContainer) {
            if (currentY - item.getH() < y) throw new ItemStoreException("Cannot add items");
            if (currentX + item.getW() > x + w - item.getW()) {
                currentX = x;
                maxRowH = item.getH();
                item.draw(currentX, currentY - item.getH() - maxRowH, picture);
                currentY -= maxRowH;
                currentX += item.getW();
            } else {
                item.draw(currentX, currentY - item.getH(), picture);
                currentX += item.getW();
            }
        }
    }
}
