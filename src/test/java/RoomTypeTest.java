import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTypeTest {


    private RoomType roomType;

    @Test
    public void singleRoom() {
        roomType = RoomType.SINGLE;
        assertEquals(25, roomType.getCost());
        assertEquals(1, roomType.getCapacity());
    }

    @Test
    public void doubleRoom() {
        roomType = RoomType.DOUBLE;
        assertEquals(40, roomType.getCost());
        assertEquals(2, roomType.getCapacity());
    }

    @Test
    public void twinRoom() {
        roomType = RoomType.TWIN;
        assertEquals(40, roomType.getCost());
        assertEquals(2, roomType.getCapacity());
    }

    @Test
    public void familyRoom() {
        roomType = RoomType.FAMILY;
        assertEquals(75, roomType.getCost());
        assertEquals(4, roomType.getCapacity());
    }

    @Test
    public void penthouseRoom() {
        roomType = RoomType.PENTHOUSE;
        assertEquals(200, roomType.getCost());
        assertEquals(2, roomType.getCapacity());
    }
}