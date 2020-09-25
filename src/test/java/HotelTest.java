import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private Bedroom bedroom;
    private ConferenceRoom conferenceRoom;
    private Guest guest;

    @Before public void before() {
        hotel = new Hotel("Hotel Pedro III El Grande");
        bedrooms = new ArrayList<>();
        conferenceRooms = new ArrayList<>();
        bedroom = new Bedroom(10, RoomType.DOUBLE);
        conferenceRoom = new ConferenceRoom("Grand Hall", 100);
        guest = new Guest("Alan");
    }

    @Test public void getName() {
        assertEquals("Hotel Pedro III El Grande", hotel.getName());
    }

    @Test public void setName() {
        hotel.setName("Travelodge");
        assertEquals("Travelodge", hotel.getName());
    }

    @Test public void getBedrooms() {
        assertEquals(bedrooms, hotel.getBedrooms());
        assertEquals(0, hotel.bedroomCount());
    }

    @Test public void setBedrooms() {
        bedrooms.add(bedroom);
        hotel.setBedrooms(bedrooms);
        assertEquals(1, hotel.bedroomCount());
    }

    @Test public void getConferenceRooms() {
        assertEquals(conferenceRooms, hotel.getConferenceRooms());
        assertEquals(0, hotel.conferenceRoomCount());
    }

    @Test public void setConferenceRooms() {
        conferenceRooms.add(conferenceRoom);
        hotel.setConferenceRooms(conferenceRooms);
        assertEquals(1, hotel.conferenceRoomCount());
    }

    @Test public void buildBedroom() {
        hotel.buildBedroom(bedroom);
        assertEquals(1, hotel.bedroomCount());
    }

    @Test public void buildConferenceRoom() {
        hotel.buildConferenceRoom(conferenceRoom);
        assertEquals(1, hotel.conferenceRoomCount());
    }
}
