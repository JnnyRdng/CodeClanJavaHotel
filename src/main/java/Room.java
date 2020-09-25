import java.util.ArrayList;

public abstract class Room {

    private int capacity;
    private ArrayList<Guest> guests;

    public Room(int capacity) {
        this.capacity = capacity;
        this.guests = new ArrayList<>();
    }

    public ArrayList<Guest> getGuests() {
        return this.guests;
    }

    public void setGuests(ArrayList<Guest> guests) {
        this.guests = guests;
    }

    public void addGuest(Guest guest) {
        if (this.hasCapacity()) {
            this.guests.add(guest);
        }
    }

    public void removeGuest(Guest guest) {
        this.guests.remove(guest);
    }

    public int guestCount() {
        return this.guests.size();
    }

    public boolean hasCapacity() {
        return this.guestCount() < this.capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

}
