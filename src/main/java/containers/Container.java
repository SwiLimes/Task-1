package containers;

import items.Item;
import java.util.ArrayList;
import java.util.List;

public abstract class Container {
    protected List<Item> items = new ArrayList<>();
    private int size;

    public int getSize() {
        return size;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }




    public Item takeItem() {
        return items.get((int) Math.random());
    }
    public List<Item> getItems() {
       return this.items;
    }

    public void printItems() {
        items.forEach(System.out::println);
    }
}
