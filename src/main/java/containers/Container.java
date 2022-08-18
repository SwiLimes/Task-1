package containers;

import enums.Shape;
import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;
import exceptions.PlacedInYourself;
import items.Item;

import java.util.List;

public abstract class Container extends Item {
    protected List<Item> itemsContainer;
    protected double maxWeight;


    protected Container(String name, int size, double weight, Shape shape, String color, List<Item> itemsContainer, double maxWeight) {
        super(name, size, weight, shape, color);
        this.itemsContainer = itemsContainer;
        this.maxWeight = maxWeight;
    }

    public List<Item> getItems() {
        return itemsContainer;
    }

    /**
     * Добавить предмет
     *
     * @param item
     */
    public void addItem(Item item) {
        if (canAddItem(item)) {
            itemsContainer.add(item);
            item.setContained(true);
        }
    }

    /**
     * Вытащить предмет
     */
    public abstract Item takeItem();

    /**
     * Проверка: предмет еще не положили?
     * Проверка: может ли предмет поместиться в контейнер?
     *
     * @param item
     */
    public boolean canAddItem(Item item) {
        if(this == item) throw new PlacedInYourself();
        if(item.isContained()) throw new ItemAlreadyPlacedException();
        return true;
    }

    public double calcWeight(double itemWeight) {
        double allWeight = this.getWeight();
        for (Item item : itemsContainer) {
            if ((allWeight + item.getWeight() > maxWeight)) throw new ItemStoreException();
            else allWeight += item.getWeight();
        }
        return allWeight + itemWeight;
    }

    /**
     * Проверка: есть ли в контейнере предметы?
     */
    public boolean canTakeItem() {
        if (!itemsContainer.isEmpty()) return true;
        else return false;
    }

    /**
     * Поиск предмета по имени
     */
    public Item searchItemByName(String name) {
        Item item = null;
        if(canTakeItem()) {
            for (Item currentItem : itemsContainer) {
                if (currentItem.getName().equals(name)) item = currentItem;
            }
        }
        return item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Container name: %s | Size: %d | Shape: %s | Color: %s",
                getName(), getSize(), getShape().name(), getColor()));
        if(this.canTakeItem()) {
            sb.append("\n\nContainer items:");
            for(Item item : itemsContainer) {
                sb.append("\n" + this.getName() + " item:: " + item);
            }
        }
       return sb.toString();
    }
}
