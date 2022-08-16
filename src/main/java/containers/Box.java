package containers;

import items.Item;

import java.util.ArrayList;
import java.util.List;

public class Box extends Container {
    private List<Item> items = new ArrayList<>();
    public Box() {}

    public Box(List<Item> items) {
        this.items = items;
    }

    @Override
    public void addItem(Item item) {

    }

    @Override
    public Item takeItem() {
        return null;
    }


}
