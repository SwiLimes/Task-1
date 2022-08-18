package containers;

import enums.Shape;
import exceptions.ContainerIsEmptyException;
import exceptions.ItemStoreException;
import items.Item;
import writers.SVGWriter;

import java.util.LinkedList;
import java.util.List;

public class Stack extends Container {
    private List<Item> items = new LinkedList<>();

    public Stack(String name, int size, String color) {
        super(name, size, 0, Shape.SQUARE, color, new LinkedList<>(), 0);
    }

    public static Stack createDefaultStack() {
        return new Stack("Stack", 20, "white");
    }

    @Override
    public boolean canAddItem(Item item) {
        super.canAddItem(item);
        if(!(item.getShape().equals(Shape.FLAT)))  throw new ItemStoreException("Shape must be FLAT");
        return true;
    }

    /**
     * Вытаскивается предмет сверху
     * @return
     */
    @Override
    public Item takeItem() {
        if(!canTakeItem()) throw new ContainerIsEmptyException();
        return items.remove(items.size() - 1);

    }

    @Override
    public int getW() {
        return getSize() * 3;
    }

    @Override
    public int getH() {
        return getSize() * 10;
    }

    @Override
    public void draw(int x, int y, SVGWriter picture) {

    }
}
