package containers;

import items.Item;
import java.util.ArrayList;
import java.util.List;

public abstract class Container {
//    protected List<Item> items = new ArrayList<>();
    private int size;


    public int getSize() {
        return size;
    }

    /**
     * Добавить предмет
     * @param item
     */
    public abstract void addItem(Item item);




    public abstract Item takeItem();

//    public abstract void printItems();
}
