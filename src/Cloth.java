public class Cloth implements IDry{
    private String type; // вид одежды (белье носок и тп)
    private Characteristic characteristic;
    private double rateSoak; // 0 - сухой, 1 - мокрый

    public Cloth(String type, double rateSoak) {
        this.type = type;
        this.rateSoak = rateSoak;
    }

    public void setCharacteristic (Characteristic characteristic) {
        this.characteristic = characteristic;
    }
    public Characteristic getCharacteristic () {
        return this.characteristic;
    }

    public void wet() {
        this.rateSoak = 1;
        if (characteristic != null)
            System.out.println(this.characteristic.getTitle() + " " + this.type + " намок");
        else
            System.out.println(this.type + " намок");

    }
    public void dry() {
        this.rateSoak += 0.3;
        if (this.characteristic != null) {
            System.out.println(this.characteristic.getTitle() + " " + this.type + " стал сухим на 30% больше");
        } else {
            System.out.println(this.type + " стал сухим на 30% больше");
        }
    }

    public void dryOn(Dryer place) {
        if (place.getTemperature() >= 75) {
            this.rateSoak = 0;
            if (this.characteristic != null) {
                System.out.println(this.characteristic.getTitle() + "  " + this.type + " сохнет");
            } else {
                System.out.println(this.type + " сохнет");
            }
        } else if (place.getTemperature() >= 0 && place.getTemperature() <= 75) {
            this.rateSoak += (double) 100 / place.getTemperature();
            if (this.characteristic != null) {
                System.out.println(this.characteristic.getTitle() + "  " + this.type + " станет менее мокрым на " + String.valueOf(place.getTemperature()) + "% больше");
            } else {
                System.out.println(this.type + " станет менее мокрым на " + String.valueOf(place.getTemperature()) + "% больше");
            }
        }
    }

    }
