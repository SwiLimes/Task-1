package containers;

import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;
import items.Apple;
import items.Item;

import java.util.ArrayList;
import java.util.List;

public class Bag extends Container {
    private List<Item> items = new ArrayList<>();
    final static int maxWeight = 100;               // Максимально-допустимый вес
//    private double allWeight = 0;

    @Override
    public Item takeItem() {
        return null;
    }

    public Bag() {
    }

    public Bag(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public void addItem(Item item) {
        items.add(item);
        getWeight();


    }

    /**
     * Подсчет общего веса в сумке
     */
    public double getWeight() {
        double allWeight = 0;
        for (Item item : items) {
            try {
                if ((allWeight + item.getWeight() > maxWeight)) throw new ItemStoreException();
                else allWeight += item.getWeight();
            } catch (ItemStoreException exception) {
                System.out.println("Вес сумки превышает предельное значение");
            }
        }
        return allWeight;
    }

    /**
     * Поиск предмета по имени
     */
    public Item searchByName(String name) {
        Item item = null;
        if (!items.isEmpty()) {
            for (Item currentItem : items) {
                if (currentItem.getName().equals(name)) item = currentItem;
            }
        }
        return item;
    }

}
