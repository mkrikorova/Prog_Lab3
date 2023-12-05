import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Math.*;

public class Shorty implements ICook{
    private String name;
    private int age;
    private boolean gender;// 1 - жен, 0 - муж
    private double weight;
    private Room location;
    ArrayList<Cloth> outfit = new ArrayList<Cloth>();

    public Shorty(String name, int age, boolean gender, double weight) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        //System.out.println("создался коротышка " + this.name);
    }
    public String getName() {
        return this.name;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    public void move(Room room) {
        this.location = room;
    }

    public void setLocation(Room room) {
        this.location = room;
        System.out.println(this.name + " был в " + room.getName());
    }
    public void putOnCloth(Cloth item) {
        outfit.add(item);
    }
    public void removeCloth(Cloth item) {
        outfit.remove(item);
    }
    public void bake(String product) {
        System.out.println(this.name + " печет " + product);
    }
    public void stew(String product) {
        System.out.println(this.name + " варит " + product);
    }
    public void fry(String product) {
        System.out.println(this.name + " жарит " + product);
    }

    @Override
    public String toString() {
        if (this.gender) {
            if (this.age <= 13) {
                return "девочка " + String.valueOf(this.age) + " лет " + this.name;
            } else if (this.age >= 14 && this.age <= 35) {
                return "девушка " + String.valueOf(this.age) + " лет " + this.name;
            } else {
                return "женщина " + String.valueOf(this.age) + " лет " + this.name;
            }
        } else {
            if (this.age <= 13) {
                return "мальчик " + String.valueOf(this.age) + " лет " + this.name;
            } else if (this.age >= 14 && this.age <= 35) {
                return "парень " + String.valueOf(this.age) + " лет " + this.name;
            } else {
                return "мужчина " + String.valueOf(this.age) + " лет " + this.name;
            }
        }
    }
    @Override
    public boolean equals(Object o) { //их эквивалентность относительно того, сколько на полке кг
        if (o instanceof Shorty) {
            Shorty shorty = (Shorty) o;
            if (this.weight == shorty.weight) {
                return true;
            } else {
                return false;
            }
        }
        return false;


    }
    @Override
    public int hashCode(){
        return (int)(this.name.hashCode() + this.age + ceil(this.weight));
    }
}
