package tests;

import containers.*;
import enums.Shape;
import items.Apple;
import items.Board;
import items.Brick;
import items.Item;
import writers.SVGWriter;


import java.awt.*;
import java.io.IOException;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        SVGWriter pic = new SVGWriter();

        Box box = Box.createDefaultBox();
        for(int i = 0; i <= 10; ++i) box.addItem(Apple.createDefaultApple());
        for(int i = 0; i <= 6; ++i) box.addItem(Board.createDefaultBoard());

//        for(int i = 0; i <= 7; ++i) box.addItem(Brick.createDefaultBrick());
//        for(int i = 0; i <= 2; ++i) box.addItem(Board.createDefaultBoard());





        box.draw(0, 0, pic);
        pic.writeBody();
        pic.writeFooter();;

        try {
            Desktop.getDesktop().open(pic.getFile());
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        System.out.println(box);



    }
}
