public class Pipe extends Dryer {
    private String material;
    private String size;
    private int temperature;
    public Pipe(String material, String size, int temperature) {
        super(material, temperature);

        this.material = material;
        this.size = size;
        //System.out.println("создалась " + this.size + " " + this.material + " труба");
    }
    @Override
    public String getDryerType() {
        return this.size + " " + this.material;
    }
}
