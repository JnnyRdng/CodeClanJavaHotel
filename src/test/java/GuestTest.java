import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {


    private Guest guest;

    @Before public void before() {
        guest = new Guest("Kevin");
    }

    @Test public void getName() {
        assertEquals("Kevin", guest.getName());
    }

    @Test public void setName() {
        guest.setName("Perry");
        assertEquals("Perry", guest.getName());
    }

}
