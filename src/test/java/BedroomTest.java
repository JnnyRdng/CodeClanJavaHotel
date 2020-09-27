import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BedroomTest {

    private Bedroom bedroom;
    private Bedroom bigRoom;
    private Guest guest1;
    private Guest guest2;

    @Before
    public void before() {
        bedroom = new Bedroom(15, RoomType.SINGLE);
        bigRoom = new Bedroom(10, RoomType.FAMILY);
        guest1 = new Guest("Jimmy");
        guest2 = new Guest("Timmy");
    }

    @Test
    public void hasRoomNumber() {
        assertEquals(15, bedroom.getRoomNumber());
    }

    @Test
    public void changeRoomNumber() {
        bedroom.setRoomNumber(20);
        assertEquals(20, bedroom.getRoomNumber());
    }

    @Test
    public void hasRoomType() {
        assertEquals(RoomType.SINGLE, bedroom.getRoomType());
    }

    @Test
    public void hasCapacity() {
        assertEquals(1, bedroom.getCapacity());
    }

    @Test
    public void familyRoomCapacity() {
        assertEquals(4, bigRoom.getCapacity());
    }

    @Test
    public void hasNoGuests() {
        assertEquals(0, bedroom.guestCount());
        ArrayList<Guest> emptyList = new ArrayList<>();
        assertEquals(emptyList, bedroom.getGuests());
    }

    @Test
    public void canAddAGuest() {
        bedroom.addGuest(guest1);
        assertEquals(1, bedroom.guestCount());
    }

    @Test
    public void canRemoveGuest() {
        bedroom.addGuest(guest1);
        bedroom.removeGuest(guest1);
        assertEquals(0, bedroom.guestCount());
    }

    @Test
    public void cantAddGuestsPastCapacity() {
        bedroom.addGuest(guest1);
        bedroom.addGuest(guest2);
        assertEquals(1, bedroom.guestCount());
    }

    @Test
    public void addListOfGuests() {
        ArrayList<Guest> guests = new ArrayList<>();
        guests.add(guest1);
        guests.add(guest2);
        bigRoom.addGuests(guests);
        assertEquals(2, bigRoom.guestCount());
    }

    @Test
    public void getCostPerNight() {
        assertEquals(25, bedroom.getCost());
        assertEquals(75, bigRoom.getCost());
    }

    @Test
    public void roomHasCapacityForMultipleGuests() {
        ArrayList<Guest> guests = new ArrayList<>();
        guests.add(guest1);
        guests.add(guest2);
        assertTrue(bigRoom.hasCapacity(guests));
        bigRoom.addGuests(guests);
        assertEquals(2, bigRoom.guestCount());
    }

    @Test
    public void roomDoesNotHaveCapacityForMultipleGuests() {
        ArrayList<Guest> guests = new ArrayList<>();
        guests.add(guest1);
        guests.add(guest2);
        bedroom.addGuests(guests);
        assertFalse(bedroom.hasCapacity(guests));
        assertEquals(0, bedroom.guestCount());
    }
}
