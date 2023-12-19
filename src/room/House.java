package room;

import errors.TryZeroRoomsException;
import shorty.Shorty;

import java.util.ArrayList;

public class House {
    private String condition;
    ArrayList<Shorty> visitors = new ArrayList<Shorty>();
    ArrayList<Room> rooms = new ArrayList<Room>();
    public House (String signboardName, String condition, String roomName, String roomVolume) {
        this.condition = condition;
        Room room = new Room(roomName, roomVolume);
        rooms.add(room);
        Signboard.setName(signboardName);
    }
    public House (String signboardName, String condition, String roomName, String roomVolume, ArrayList<Shorty> roomNowVisitor) {
        this.condition = condition;
        Room room = new Room(roomName, roomVolume, roomNowVisitor);
        this.addRoom(room);
        Signboard.setName(signboardName);
    }
    public String getSignboard() {
        return Signboard.getName();
    }
    public void setSignboard(String newSignboard) {
        Signboard.setName(newSignboard);
    }

    public void addVisitor(Shorty shorty) {
        visitors.add(shorty);
        System.out.print(shorty.getName()+" вошел в " + this.getSignboard() + ". ");
        rooms.get(0).addVisitor(shorty);
    }
    public void removeVisitor(Shorty shorty) {
        visitors.remove(shorty);
        for (Room room : this.rooms) {
            room.removeVisitor(shorty);
        }
        System.out.println(shorty.getName()+" вышел из " + this.getSignboard());
    }
    public int countVisitors() {
        return visitors.size();
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }
    public void removeRoom(Room room) throws TryZeroRoomsException {
        if (this.countRoom() == 1) {
            throw new TryZeroRoomsException("Нельзя чтобы в доме не было комнат!");
        } else {
            this.rooms.remove(room);
        }
    }
    public int countRoom() {
        return rooms.size();
    }

    public String getCondition() {
        return this.condition;
    }
    public static class Signboard {
        static String name;
        public static String getName() {
            return name;
        }
        public static void setName(String newName) {
            name = newName;
        }
    }
}
