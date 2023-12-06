package RoomAndAllInside;

import RoomAndAllInside.Dryer;

public class Rope extends Dryer {

    private int length;
    private String material;
    private int temperature;
    public Rope(int length, String material, int temperature) {
        super(material, temperature);

        this.length = length;
        //System.out.println("созадалась веревка");
    }
}
