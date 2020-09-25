public class Booking {

    private Bedroom bedroom;
    private int nights;

    public Booking(Bedroom bedroom, int nights) {
        this.bedroom = bedroom;
        this.nights = nights;
    }

    public Bedroom getRoom() {
        return this.bedroom;
    }

    public int getNights() {
        return this.nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }
}
