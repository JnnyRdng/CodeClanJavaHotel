import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HotelTest {

    private Hotel hotel;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private Bedroom bedroom;
    private Bedroom bedroom2;
    private ConferenceRoom conferenceRoom;
    private ConferenceRoom conferenceRoom2;
    private Guest guest;
    private DiningRoom diningRoom;

    @Before
    public void before() {
        hotel = new Hotel("Hotel Pedro III El Grande");
        bedrooms = new ArrayList<>();
        conferenceRooms = new ArrayList<>();
        bedroom = new Bedroom(10, RoomType.DOUBLE);
        bedroom2 = new Bedroom(10, RoomType.SINGLE);
        conferenceRoom = new ConferenceRoom("Grand Hall", 100);
        conferenceRoom2 = new ConferenceRoom("Broom Cupboard", 1);
        guest = new Guest("Alan");
        diningRoom = new DiningRoom("Nandos", 10);
    }

    @Test
    public void getName() {
        assertEquals("Hotel Pedro III El Grande", hotel.getName());
    }

    @Test
    public void setName() {
        hotel.setName("Travelodge");
        assertEquals("Travelodge", hotel.getName());
    }

    @Test
    public void getBedrooms() {
        assertEquals(bedrooms, hotel.getBedrooms());
        assertEquals(0, hotel.bedroomCount());
    }

    @Test
    public void setBedrooms() {
        bedrooms.add(bedroom);
        hotel.setBedrooms(bedrooms);
        assertEquals(1, hotel.bedroomCount());
    }

    @Test
    public void getConferenceRooms() {
        assertEquals(conferenceRooms, hotel.getConferenceRooms());
        assertEquals(0, hotel.conferenceRoomCount());
    }

    @Test
    public void setConferenceRooms() {
        conferenceRooms.add(conferenceRoom);
        hotel.setConferenceRooms(conferenceRooms);
        assertEquals(1, hotel.conferenceRoomCount());
    }

    @Test
    public void buildBedroom() {
        hotel.buildBedroom(bedroom);
        assertEquals(1, hotel.bedroomCount());
    }

    @Test
    public void buildConferenceRoom() {
        hotel.buildConferenceRoom(conferenceRoom);
        assertEquals(1, hotel.conferenceRoomCount());
    }

    @Test
    public void cantCheckIntoBedroomIfNoBedrooms() {
        assertFalse(hotel.checkIntoBedroom(guest));
    }

    @Test
    public void canCheckGuestIntoBedroom() {
        hotel.buildBedroom(bedroom);
        assertTrue(hotel.checkIntoBedroom(guest));
        assertEquals(1, bedroom.guestCount());
    }

    @Test
    public void guestGoesIntoNextBedroomIfFirstFull() {
        hotel.buildBedroom(bedroom2);
        hotel.buildBedroom(bedroom);
        hotel.checkIntoBedroom(guest);
        hotel.checkIntoBedroom(guest);
        assertEquals(1, bedroom2.guestCount());
        assertEquals(1, bedroom.guestCount());
    }

    @Test
    public void cantCheckIntoConferenceRoomIfNoConferenceRooms() {
        assertFalse(hotel.checkIntoConferenceRoom(guest));
    }

    @Test
    public void canCheckGuestIntoConferenceRoom() {
        hotel.buildConferenceRoom(conferenceRoom);
        assertTrue(hotel.checkIntoConferenceRoom(guest));
        assertEquals(1, conferenceRoom.guestCount());
    }

    @Test
    public void guestGoesIntoNextConferenceRoomIfFirstFull() {
        hotel.buildConferenceRoom(conferenceRoom2);
        hotel.buildConferenceRoom(conferenceRoom);
        hotel.checkIntoConferenceRoom(guest);
        hotel.checkIntoConferenceRoom(guest);
        assertEquals(1, conferenceRoom2.guestCount());
        assertEquals(1, conferenceRoom.guestCount());
    }

    @Test
    public void canCheckOutGuestFromBedroom() {
        hotel.buildBedroom(bedroom);
        hotel.checkIntoBedroom(guest);
        assertTrue(hotel.checkOutFromBedroom(guest));
        assertEquals(0, bedroom.guestCount());
    }

    @Test
    public void cantCheckOutGuestIfNotInBedroom() {
        hotel.buildBedroom(bedroom);
        assertFalse(hotel.checkOutFromBedroom(guest));
    }

    @Test
    public void canCheckOutGuestFromConferenceRoom() {
        hotel.buildConferenceRoom(conferenceRoom);
        hotel.checkIntoConferenceRoom(guest);
        assertTrue(hotel.checkOutFromConferenceRoom(guest));
        assertEquals(0, conferenceRoom.guestCount());
    }

    @Test
    public void cantCheckOutGuestIfNotInConferenceRoom() {
        hotel.buildConferenceRoom(conferenceRoom);
        assertFalse(hotel.checkOutFromConferenceRoom(guest));
    }

    @Test
    public void hasEmptyBookings() {
        assertEquals(new ArrayList<Booking>(), hotel.getBookings());
        assertEquals(0, hotel.bookingsCount());
    }

    @Test
    public void canAddBooking() {
        Booking booking = new Booking(bedroom, 3);
        hotel.addBooking(booking);
        assertEquals(1, hotel.bookingsCount());
    }

    @Test
    public void canBookRoom() {
        Booking newBooking = hotel.bookRoom(bedroom, 3);
        assertEquals(3, newBooking.getNights());
        assertEquals(120, newBooking.getTotalCost());
        assertEquals(2, newBooking.getRoom().getCapacity());
    }

    @Test
    public void emptyDiningRoomsHashMap() {
        assertEquals(0, hotel.getDiningRooms().size());
    }

    @Test
    public void addDiningRoomToHashMap() {
        hotel.addDiningRoom(diningRoom);
        assertEquals(1, hotel.getDiningRooms().size());
    }

    @Test
    public void getDiningRoomByName() {
        hotel.addDiningRoom(diningRoom);
        DiningRoom returnedDiningRoom = hotel.getDiningRoomByName("Nandos");
        assertEquals("Nandos", returnedDiningRoom.getName());
        assertEquals(10, returnedDiningRoom.getCapacity());
    }

    @Test
    public void noEmptyBedrooms() {
        assertEquals(0, hotel.getEmptyBedrooms().size());
    }

    @Test
    public void oneEmptyBedroom() {
        bedroom2.addGuest(guest);
        hotel.buildBedroom(bedroom2);
        hotel.buildBedroom(bedroom);
        assertEquals(1, hotel.getEmptyBedrooms().size());
    }

    @Test
    public void addGuestsOnlyToEmptyBedroom() {
        hotel.buildBedroom(bedroom);
        hotel.buildBedroom(bedroom2);
        hotel.buildBedroom(bedroom2);
        hotel.checkIntoBedroom(guest);
        hotel.checkIntoBedroom(guest);
        assertEquals(1, bedroom.guestCount());
        assertEquals(1, bedroom2.guestCount());
    }
}
