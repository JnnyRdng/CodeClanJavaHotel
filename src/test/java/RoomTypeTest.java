import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTypeTest {


    private RoomType roomType;

    @Test public void singleRoomCapacity() {
        roomType = RoomType.SINGLE;
        assertEquals(1, roomType.getCapacity());
    }
    @Test public void doubleRoomCapacity() {
        roomType = RoomType.DOUBLE;
        assertEquals(2, roomType.getCapacity());
    }
    @Test public void twinRoomCapacity() {
        roomType = RoomType.TWIN;
        assertEquals(2, roomType.getCapacity());
    }
    @Test public void familyRoomCapacity() {
        roomType = RoomType.FAMILY;
        assertEquals(4, roomType.getCapacity());
    }
    @Test public void penthouseRoomCapacity() {
        roomType = RoomType.PENTHOUSE;
        assertEquals(2, roomType.getCapacity());
    }
}