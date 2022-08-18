package containers;

import enums.Shape;
import exceptions.ContainerIsEmptyException;
import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;
import items.Item;
import writers.SVGWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Box extends Container {
    public Box(String name, int size, double weight, String color, double maxWeight) {
        super(name, size, weight, Shape.SQUARE, color, new ArrayList<>(), maxWeight);
    }

    public static Box createDefaultBox() {
        return new Box("Box", 50, 15, "aqua", 250);
    }

    @Override
    public double calcWeight(double itemWeight) {
        return super.calcWeight(itemWeight);
    }

    @Override
    public int getW() {
        return getSize() * 10;
    }

    @Override
    public int getH() {
        return getSize() * 10;
    }

    @Override
    public Item takeItem() {
        if (canTakeItem()) return itemsContainer.get(0);
        else throw new ContainerIsEmptyException();
    }

    @Override
    public Item searchItemByName(String name) {
        return null;
    }

    @Override
    public void draw(int x, int y, SVGWriter picture) {
        int w = getW();
        int h = getH();
        picture.writeRect(x, y, w, h, getColor());
        int currentX = x;
        int currentY = y + h;
        int maxRowH = 0;
        if (!canTakeItem()) return;
        for (Item item : itemsContainer) {
            if (currentX + item.getW() > x + w - item.getW()) {
                if (currentY - item.getH() * 2 - 2 < y) throw new ItemStoreException(String.format("CurrentY=%d, CurrentX=%d, count=%d", currentY, currentX));
                currentX = x;
                maxRowH = item.getH();
                currentY -= maxRowH;
                if (item.getShape().equals(Shape.CIRCLE)) {
                    item.draw(currentX + item.getW(), currentY - item.getH() * 2 - 2, picture);
                    currentY -= item.getH();
                    currentX += item.getW() * 2 + 2;
                } else {
                    item.draw(currentX, currentY - item.getH(), picture);
                    currentX += item.getW();
                }
            } else {
                if (item.getShape().equals(Shape.CIRCLE)) {
                    item.draw(currentX + item.getW(), currentY - item.getH() - 2, picture);
                    currentX += item.getW() * 2 + 2;
                } else {
                    item.draw(currentX, currentY - item.getH(), picture);
                    currentX += item.getW();
                }
            }
        }
//            if (currentX + item.getW() > x + w - item.getW()) {
//                currentX = x;
//                if(item.getShape().equals(Shape.CIRCLE)) {
//                    maxRowH = item.getH();
//                    item.draw(currentX + item.getW(), currentY, picture);
//
//                    currentX += item.getW()*2 + 2;
//
////                    maxRowH = item.getH();
//                } else {
//                    currentY -= maxRowH;
//                    maxRowH = item.getH();
//
//                    item.draw(currentX, currentY - item.getH(), picture);
//                }
//            } else {
//                if (item.getShape().equals(Shape.CIRCLE)) {
//                    item.draw(currentX + item.getW(), currentY - item.getH() - 2, picture);
//                    currentX += item.getW()*2 + 2;
//                } else {
//                    item.draw(currentX, currentY - item.getH(), picture);
//                    currentX += item.getW();
//                }
//            }
//            if (maxRowH < item.getH()) maxRowH = item.getH();
//        }
    }

}
//            if(item.getShape().equals(Shape.CIRCLE)) {
//                currentY -= item.getH();
//                draw(currentX, currentY - item.getH(), picture);
//                currentX += item.getW() * 2;
//            } else {
//                item.draw(currentX, currentY - item.getH(), picture);
////                    currentX += item.getW();
//            }
//            draw(currentX, currentY, picture);
