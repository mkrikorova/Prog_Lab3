package RoomAndAllInside;

public class Bulb {
    private String brightness;
    public Bulb(String brightness) {
        this.brightness = brightness;
        //System.out.println("создалась " + this.brightness + "  лампочка");
    }
    public String getBrightness() {
        return this.brightness;
    }
}
