package room;
import shorty.*;
import java.util.ArrayList;

public class Shelve {
    private String material;
    private String status;
    private int number;

    String mattress;
    String pillow;
    ArrayList<Shorty> people = new ArrayList<Shorty>();

    public Shelve(String material, String status) {
        this.material = material;
        this.status = status;
        //System.out.println("создалась " + this.status + " " + this.material + " полка");
    }
    public Shelve(int number, String material, String status) {
        this.material = material;
        this.status = status;
        this.number = number;
        //System.out.println("создалась " + this.status + " " + this.material + " полка");
    }
    public void addPeople(Shorty shorty) {
        people.add(shorty);
    }
    public void removePeople(Shorty shorty) {
        people.remove(shorty);
    }
    public int countPeople() {
        return people.size();
    }
    public ArrayList getPeople() {
        return people;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    public String getShelve() {
        return this.material + " " + this.status;
    }

    public String getMattress() {
        if (this.mattress == null) {
            return "не было матраца";
        }
        return this.mattress;
    }

    public void setMattress(String mattress) {
        this.mattress = mattress;
    }

    public String getPillow() {
        if (this.pillow == null) {
            return "не было подушки";
        }
        return this.pillow;
    }

    public void setPillow(String pillow) {
        this.pillow = pillow;
    }
}
