import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {

    private String name;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<Booking> bookings;
    private HashMap<String, DiningRoom> diningRooms;

    public Hotel(String name) {
        this.name = name;
        this.bedrooms = new ArrayList<>();
        this.conferenceRooms = new ArrayList<>();
        this.bookings = new ArrayList<>();
        this.diningRooms = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Bedroom> getBedrooms() {
        return this.bedrooms;
    }

    public int bedroomCount() {
        return this.bedrooms.size();
    }

    public void setBedrooms(ArrayList<Bedroom> bedrooms) {
        this.bedrooms = bedrooms;
    }

    public ArrayList<ConferenceRoom> getConferenceRooms() {
        return this.conferenceRooms;
    }

    public int conferenceRoomCount() {
        return this.conferenceRooms.size();
    }

    public void setConferenceRooms(ArrayList<ConferenceRoom> conferenceRooms) {
        this.conferenceRooms = conferenceRooms;
    }

    public void buildBedroom(Bedroom bedroom) {
        this.bedrooms.add(bedroom);
    }

    public void buildConferenceRoom(ConferenceRoom conferenceRoom) {
        this.conferenceRooms.add(conferenceRoom);
    }

    public boolean checkIntoBedroom(Guest guest) {
        for (Bedroom bedroom : this.getEmptyBedrooms()) {
            if (bedroom.hasCapacity()) {
                bedroom.addGuest(guest);
                return true;
            }
        }
        return false;
    }

    public boolean checkIntoConferenceRoom(Guest guest) {
        for (ConferenceRoom conferenceRoom : this.conferenceRooms) {
            if (conferenceRoom.hasCapacity()) {
                conferenceRoom.addGuest(guest);
                return true;
            }
        }
        return false;
    }

    public boolean checkOutFromBedroom(Guest guest) {
        for (Bedroom bedroom : this.bedrooms) {
            if (bedroom.getGuests().contains(guest)) {
                bedroom.removeGuest(guest);
                return true;
            }
        }
        return false;
    }

    public boolean checkOutFromConferenceRoom(Guest guest) {
        for (ConferenceRoom conferenceRoom : this.conferenceRooms) {
            if (conferenceRoom.getGuests().contains(guest)) {
                conferenceRoom.removeGuest(guest);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Booking> getBookings() {
        return this.bookings;
    }

    public int bookingsCount() {
        return this.bookings.size();
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }

    public Booking bookRoom(Bedroom bedroom, int nights) {
        return new Booking(bedroom, nights);
    }

    public HashMap<String, DiningRoom> getDiningRooms() {
        return this.diningRooms;
    }

    public DiningRoom getDiningRoomByName(String name) {
        return this.diningRooms.get(name);
    }

    public void addDiningRoom(DiningRoom diningRoom) {
        this.diningRooms.put(diningRoom.getName(), diningRoom);
    }

    public ArrayList<Bedroom> getEmptyBedrooms() {
        ArrayList<Bedroom> emptyBedrooms = new ArrayList<>();
        for (Bedroom bedroom : this.bedrooms) {
            if (bedroom.guestCount() == 0) {
                emptyBedrooms.add(bedroom);
            }
        }
        return emptyBedrooms;
    }

}
