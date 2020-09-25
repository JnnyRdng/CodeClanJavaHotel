import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    private ConferenceRoom confRoom;

    @Before public void before() {
        confRoom = new ConferenceRoom("Grand Hall", 500);
    }

    @Test public void hasName() {
        assertEquals("Grand Hall", confRoom.getName());
    }

    @Test public void canSetName() {
        confRoom.setName("The Henry VIII Grand Hall");
        assertEquals("The Henry VIII Grand Hall", confRoom.getName());
    }

    @Test public void canGetCapacity() {
        assertEquals(500, confRoom.getCapacity());
    }
}
