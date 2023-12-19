import inerfaces.IWalk;
import room.*;
import shorty.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Shorty nezhayka = new Shorty("Незнайка", 7, false, 23.4);
        Shorty kozlik = new Shorty("Козлик", 6, false, 21.8);
        Shorty habitat1 = new Shorty("Обитатель1", 10, false, 30.0);
        Shorty habitat2 = new Shorty("Обитатель2", 10, false, 30.0);
        //System.out.println(nezhayka.toString());
        IWalk walk = new IWalk() {
            @Override
            public void streetWalk(String street, Shorty shorty) {
                System.out.println(shorty.getName() + " шел по улице " + street);
            }
        };
        walk.streetWalk("Большая Трущобная", nezhayka);
        walk.streetWalk("Большая Трущобная", kozlik);
        walk.streetWalk("Малая Трущобная", nezhayka);
        walk.streetWalk("Малая Трущобная", kozlik);
        System.out.println();

        House hotel = new House("'Общедоступная гостиница ...Тупичок'",
                "напоминавший огромный мусорный ящик", "приемная",
                "маленькая");
        System.out.println("На " + hotel.getCondition() + " доме висела вывеска " + hotel.getSignboard());
        hotel.addVisitor(nezhayka);
        hotel.addVisitor(kozlik);

        ArrayList<Shorty> nowVisitors = new ArrayList<Shorty>();
        nowVisitors.add(habitat1);
        nowVisitors.add(habitat2);
        Room room = new Room("'Второй подземный этаж'", "огромная", nowVisitors);
        hotel.addRoom(room);
        room.addOven("чугунная");
        room.addPipe("жестяная", "длинная", 85);
        nezhayka.move(room);
        kozlik.move(room);
        System.out.println();

        room.getRoomCeiling();
        habitat1.setLocation(room);
        room.getWall(0).addPeople(0, habitat1);
        habitat2.setLocation(room);
        room.getWall(0).addPeople(0, habitat2);
        room.getRoomElements();

        habitat1.bake("картошка");
        habitat2.stew("похлебка");
        habitat1.fry(Characteristic.SHAPELESS.getTitle()+ " корж");

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
        System.out.println();

        nezhayka.setHealth("почувствовал головокружение и побледнел");
        System.out.println(nezhayka.getName() + " " + nezhayka.getHealth());
        Shelve shelve215 = new Shelve(215, "деревянная", "неотесанная");
        Shelve shelve216 = new Shelve(216, "деревянная", "неотесанная");
        shelve215.setMattress(null);
        shelve215.setPillow("простой деревянный чурбан");
        System.out.println("На полке номер " + shelve215.getNumber() + " " + shelve215.getMattress() + " и вместо подушки был " + shelve215.getPillow());
        nezhayka.setHealth("было нестерпимо душно");
        System.out.println(nezhayka.getName() + " " + nezhayka.getHealth());
        nezhayka.undress();
        nezhayka.fallAsleep();

    }
}