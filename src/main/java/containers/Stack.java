package containers;

import enums.Shape;
import items.Item;

import java.util.LinkedList;
import java.util.List;

public class Stack extends Container {
    private List<Item> items = new LinkedList<>();
    @Override
    public void addItem(Item item) {
        if(item.getShape().equals(Shape.FLAT)) items.add(item);
        else throw new IllegalArgumentException("В стопку можно положить только плоские предметы");
    }
    @Override
    public Item takeItem() {
        return items.remove(items.size() - 1);
    }

    public void showStack() {
        for(Item item : items) System.out.println(item);
    }
}
