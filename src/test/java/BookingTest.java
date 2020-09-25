import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookingTest {

    private Booking booking;

    @Before
    public void before() {
        Bedroom bedroom = new Bedroom(12, RoomType.DOUBLE);
        booking = new Booking(bedroom, 3);
    }

    @Test
    public void bookingHasARoom() {
        assertNotNull(booking.getRoom());
        assertEquals(12, booking.getRoom().getRoomNumber());
    }

    @Test
    public void bookingHasDuration() {
        assertEquals(3, booking.getNights());
    }

    @Test
    public void changeBookingDuration() {
        booking.setNights(5);
        assertEquals(5, booking.getNights());
    }

    @Test
    public void calculateTotalCost() {
        assertEquals(120, booking.getTotalCost());
    }

    @Test
    public void totalCostChangesIfDurationChanges() {
        booking.setNights(5);
        assertEquals(200, booking.getTotalCost());
    }
}
