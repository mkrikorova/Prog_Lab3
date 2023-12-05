import java.util.ArrayList;

public class Shelve {
    private String material;
    private String status;
    ArrayList<Shorty> people = new ArrayList<Shorty>();

    public Shelve(String material, String status) {
        this.material = material;
        this.status = status;
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

    public String getShelve() {
        return this.material + " " + this.status;
    }
}
