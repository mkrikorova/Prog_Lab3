public class Main {
    public static void main(String[] args) {
        Shorty nezhayka = new Shorty("Незнайка", 7, false, 23.4);
        Shorty kozlik = new Shorty("Козлик", 6, false, 21.8);
        System.out.println(nezhayka.toString());
        Room room = new Room("'Второй подземный этаж'", "огромная");
        System.out.println();
        nezhayka.move(room);
        kozlik.move(room);
        room.addVisitor(nezhayka);
        room.addVisitor(kozlik);
        room.getRoomCeiling();
        Shorty habitats = new Shorty("Обитатели", 10, false, 30.0);
        habitats.setLocation(room);
        room.addPeople(0, habitats);
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
    }
}