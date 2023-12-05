import java.util.ArrayList;

abstract public class Dryer {
    ArrayList<Cloth> clothes = new ArrayList<Cloth>();
    private int temperature;
    private String material;

    public Dryer(String material, int temperature) {
        this.material = material;
        this.temperature = temperature;
        //System.out.println("создалось место для сушки");
    }

    public void setTemperature(int t) {
        this.temperature = t;
    }
    public int getTemperature() {
        return this.temperature;
    }
    public void addCloth(Cloth item) {
        clothes.add(item);
    }
    public void removeCloth(Cloth item) {
        clothes.remove(item);
    }
    public int countCloth() {
        return clothes.size();
    }
    public String getDryerType() {
        return this.material;
    }
}
