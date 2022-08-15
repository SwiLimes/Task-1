package containers;

import enums.Shape;
import items.Item;

public class Stack extends Container {
    @Override
    public void addItem(Item item) {
        if(item.getShape().equals(Shape.FLAT)) super.addItem(item);
        else throw new IllegalArgumentException("В стопку можно положить только плоские предметы");
    }
}
