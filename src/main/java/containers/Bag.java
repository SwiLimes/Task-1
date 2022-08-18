package containers;

import enums.Shape;
import exceptions.ContainerIsEmptyException;
import exceptions.ItemStoreException;
import items.Item;
import writers.SVGWriter;

import java.util.ArrayList;

public class Bag extends Container {

    public Bag(String name, int size, double weight, String color, double maxWeight) {
        super(name, size, weight, Shape.SQUARE, color, new ArrayList<>(), maxWeight);
    }

    public static Bag createDefaultBag() {
        return new Bag("Bag", 30, 5,"orange", 50);
    }

    @Override
    public Item takeItem() {
        if(canTakeItem()) return itemsContainer.remove((int)Math.random());
        else throw new ContainerIsEmptyException();
    }


    @Override
    public boolean canAddItem(Item item) {
        super.canAddItem(item);
        if(this.calcWeight(item.getWeight()) > maxWeight) throw new ItemStoreException();
        return true;
    }

    @Override
    public int getW() {
        return getSize() * 25;
    }

    @Override
    public int getH() {
        return getSize() * 10;
    }


    @Override
    public void draw(int x, int y, SVGWriter picture) {
        picture.writeRoundRect(x, y, getW(), getH(), 30, 50, getColor());
        if(canTakeItem()) {
            for (Item item : itemsContainer) {
                item.draw(x + 20, y + 60, picture);
            }
        }
    }
}
