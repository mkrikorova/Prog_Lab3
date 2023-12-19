package shorty;

import errors.NegativeNumberException;
import inerfaces.*;
import room.*;

import java.util.ArrayList;
import static java.lang.Math.*;

public class Shorty implements ICook {
    private String name;
    private int age;
    private boolean gender;// 1 - жен, 0 - муж
    private double weight;
    private Room location;
    private boolean sleepingMode = false;
    private String health; // самочувствие
    ArrayList<Cloth> outfit = new ArrayList<Cloth>();

    public Shorty(String name, int age, boolean gender, double weight) {
        if (age <= 0 || weight <= 0) {
            throw new NegativeNumberException("Введено отрицательное число в возраст или вес");
        }
        this.setName(name);
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        //System.out.println("создался коротышка " + this.name);
    }
    public Shorty(String name, int age, boolean gender, double weight, String health) {
        if (age <= 0 || weight <= 0) {
            throw new NegativeNumberException("Введено отрицательное число в возраст или вес");
        }
        this.setName(name);
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.health = health;
        //System.out.println("создался коротышка " + this.name);
    }


    public String getName() {
        return this.name;
    }
    public void setName(String newName) {
        class CorrectName {
            public boolean CheckName(String str) {//проверка имен
                return true;
            }
        }
        CorrectName correctName = new CorrectName();
        if (correctName.CheckName(newName)) {
            this.name = newName;
        } else {
            System.out.println("Это не имя! Попробуйте ещё.");
        }

    }

    public void move(Room room) {
        this.location = room;
        room.addVisitor(this);
    }
    public void setLocation(Room room) {
        this.location = room;
        //System.out.println(this.name + " был в " + room.getName());
    }
    public String getLocation(){
        System.out.println(this.name + " сейчас в комнате " + this.location.getName());
        return this.location.getName();
    }

    public void putOnCloth(Cloth item) {
        outfit.add(item);
    }
    public void removeCloth(Cloth item) {
        outfit.remove(item);
    }

    public void undress() {
        int n = this.outfit.size();
        for (Cloth cloth : this.outfit) {
            this.removeCloth(cloth);
        }
        System.out.println(this.name + " разделся");
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

    public void lieDown(Shelve shelve) {
        shelve.addPeople(this);
        System.out.println(this.name + " лег на полку номер " + shelve.getNumber());
    }
    public void standUp(Shelve shelve) {
        shelve.removePeople(this);
        System.out.println(this.name + " встал с полки номер " + shelve.getNumber());
    }

    public void fallAsleep() {
        this.sleepingMode = true;
        System.out.println(this.name + " заснул");
    }
    public void wakeUp() {
        this.sleepingMode = false;
        System.out.println(this.name + " проснулся");
    }

    public void setHealth(String health) {
        this.health = health;
    }
    public String getHealth() {
        return this.health;
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
        return (int)(ceil(this.weight) * 20 + 4098);
    }
}
