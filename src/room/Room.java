package room;
import shorty.*;

import java.util.ArrayList;

public class Room {
    private String name;
    private Wall wall1;
    private Wall wall2;
    private Wall wall3;;
    private Wall wall4;
    private Ceiling ceiling;
    private Floor floor;
    private Pipe pipe;
    private Rope rope;
    private Oven oven;
    private String volume;
    ArrayList<Shorty> visitors = new ArrayList<Shorty>();

    public Room (String name, String volume) {
        this.name = name;
        this.volume = volume;
        wall1 = new Wall();
        wall2 = new Wall();
        wall3 = new Wall();
        wall4 = new Wall();
        ceiling = new Ceiling(170, "закопченный");
        floor = new Floor("бетонный");

        //System.out.println("создалась комната " + this.name);
    }

    public Room (String name, String volume, ArrayList<Shorty> nowVisitors) {
        this.name = name;
        this.volume = volume;
        wall1 = new Wall();
        wall2 = new Wall();
        wall3 = new Wall();
        wall4 = new Wall();
        ceiling = new Ceiling(170, "закопченный");
        floor = new Floor("бетонный");
        for (Shorty shorty : nowVisitors) {
            shorty.setLocation(this);
            shorty.getLocation();
            //System.out.println(shorty.getName() + " был в комнате");
        }

        //System.out.println("создалась комната " + this.name);
    }

    public String getName() {
        return this.name;
    }
    public void setName(String newName) {
        this.name = newName;
    }


    public void addVisitor(Shorty shorty) {
        visitors.add(shorty);
        System.out.println(shorty.getName()+" вошел в " + this.name);
    }
    public void removeVisitor(Shorty shorty) {
        visitors.remove(shorty);
        System.out.println(shorty.getName()+" вышел из комнаты");
    }
    public int countVisitors() {
        return visitors.size();
    }

    public void addPipe(String material, String size, int temperature) {
        pipe = new Pipe(material, size, temperature);
    }
    public void addRope(int length, String material, int temperature) {
        rope = new Rope(length, material, temperature);
    }
    public void addOven(String material) {
        oven = new Oven(material);
    }

    public void getRoomFloor() {
        System.out.println(this.floor.getMaterial());
    }
    public Pipe getRoomPipe() {
        return this.pipe;
    }
    public Wall getWall(int index) {
        switch (index) {
            case (0):
                return this.wall1;
            case (1):
                return this.wall2;
            case (2):
                return this.wall3;
            case (3):
                return this.wall4;
            default:
                return null;
        }
    }
    public void getRoomCeiling() {
        System.out.println("потолок был " + this.ceiling.getCeiling());
    }

    public void getRoomElements() {
        System.out.println(this.wall1.getWall());
        System.out.printf("в " + this.name + " были " + this.oven.getMaterial() + " печь с " + this.pipe.getDryerType() + " труба, ");
        System.out.println("на потолке висела " + this.ceiling.getBulb(0) + " лампочка");}

    public class Wall {
        ArrayList<Shelve> shelves = new ArrayList<Shelve>();
        ArrayList<Bulb> bulbs = new ArrayList<Bulb>();

        public Wall() {
            Shelve shelve1 = new Shelve("деревянная", "неотесанная");
            this.addShelve(shelve1);
            //System.out.println("создалась стена");
        }

        public void addBulb(Bulb bulb){
            bulbs.add(bulb);
        }
        public void removeBulb(Bulb bulb) {
            bulbs.remove(bulb);
        }
        public int countBulb() {
            return bulbs.size();
        }

        public void addShelve(Shelve shelve){
            shelves.add(shelve);
        }
        public void removeShelve(Shelve shelve) {
            shelves.remove(shelve);
        }
        public int countShelve() {
            return shelves.size();
        }

        public void addPeople(int index, Shorty shorty) {
            this.shelves.get(index).addPeople(shorty);
        }
        public String getWall() {
            String res = "";
            for (int i = 0; i < this.countShelve(); i++) {
                Shelve o =  shelves.get(i);
                res += ("на " + o.getShelve() + " полка лежали ");
                ArrayList<Shorty> n = o.getPeople();
                for (int j = 0; j < n.size(); j++) {
                    res += (n.get(j).getName() + " ");
                }
            }
            return res;
        }
    }

    public class Ceiling {
        private int height;
        private String status;
        ArrayList<Bulb> bulbs = new ArrayList<Bulb>();

        public Ceiling(int height, String status) {
            this.height = height;
            this.status = status;
            Bulb bulb1 = new Bulb("тусклая");
            this.addBulb(bulb1);
            //System.out.println("создался " + this.status + " " + this.height +  " потолок");
        }
        public String getCeiling () {
            String h = "";
            if (this.height > 200) {
                h = "высокий";
            } else {
                h = "низкий";
            }
            return h + " " + this.status;
        }
        public String getBulb (int index) {
            return this.bulbs.get(index).getBrightness();
        }
        public void addBulb(Bulb bulb){
            bulbs.add(bulb);
        }
        public void removeBulb(Bulb bulb) {
            bulbs.remove(bulb);
        }
        public int countBulb() {
            return bulbs.size();
        }
    }

    public class Floor {
        private String material;
        public Floor(String material) {
            this.material = material;
            //System.out.println("создлался " + this.material + " пол");
        }

        public String getMaterial() {
            return this.material;
        }
    }
}
