package containers;

import items.Apple;
import items.Item;

import java.util.ArrayList;
import java.util.List;

public class Bag extends Container {
    final static int maxWeight = 100;
    private double allWeight = 0;

    public Bag() {}

    public Bag(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public void addItem(Item item) {
        if(getWeight(item)) super.addItem(item);
        else throw new IllegalArgumentException("Превышен максимальный вес сумки");
    }

    public boolean getWeight(Item item) {
        if(allWeight + item.getWeight() > maxWeight) return false;
        allWeight += item.getWeight();
        return true;
    }
    public Item searchByName(String name) {
        Item item = null;
        if(!items.isEmpty()) {
            for(Item currentItem : items) {
                if(currentItem.getName().equals(name)) item = currentItem;
            }
        }
        return item;
    }

}
