import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {

    private DiningRoom diningRoom;

    @Before
    public void before() {
        diningRoom = new DiningRoom("Nandos", 5);
    }

    @Test
    public void hasAName() {
        assertEquals("Nandos", diningRoom.getName());
    }

    @Test
    public void hasCapacity() {
        assertEquals(5, diningRoom.getCapacity());
    }

    @Test
    public void hasGuestList() {
        assertEquals(0, diningRoom.guestCount());
    }
}
