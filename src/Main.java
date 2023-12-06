import RoomAndAllInside.*;
import ShortyAndClothers.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Shorty nezhayka = new Shorty("Незнайка", 7, false, 23.4);
        Shorty kozlik = new Shorty("Козлик", 6, false, 21.8);
        Shorty habitats = new Shorty("Обитатель", 10, false, 30.0);
        //System.out.println(nezhayka.toString());

        ArrayList<Shorty> nowVisitors = new ArrayList<Shorty>();
        nowVisitors.add(habitats);
        Room room = new Room("'Второй подземный этаж'", "огромная", nowVisitors);
        room.addOven("чугунная");
        room.addPipe("жестяная", "длинная", 85);
        System.out.println();
        nezhayka.move(room);
        kozlik.move(room);

        room.getRoomCeiling();
        habitats.setLocation(room);
        room.getRoomElements();

        habitats.bake("картошка");
        habitats.stew("похлебка");
        habitats.fry(Characteristic.SHAPELESS.getTitle()+ " корж");

        Cloth socks = new Cloth("носки", 1);
        socks.dryOn(room.getRoomPipe());
        Cloth linen = new Cloth("бельё", 0.7);
        linen.dryOn(room.getRoomPipe());
        Cloth rag = new Cloth("тряпьё", 0.9);
        rag.setCharacteristic(Characteristic.TORN);
        rag.dryOn(room.getRoomPipe());
        Cloth boots = new Cloth("ботинки", 1);
        boots.setCharacteristic(Characteristic.SOMEONE);
        boots.dryOn(room.getRoomPipe());

        //System.out.println(room.getRoomPipe().getClass()); // те выводит именно то, что написано после слово new ????
    }
}