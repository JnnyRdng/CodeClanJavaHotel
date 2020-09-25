public class Booking {

    private final Bedroom bedroom;
    private int nights;
    private int totalCost;

    public Booking(Bedroom bedroom, int nights) {
        this.bedroom = bedroom;
        this.nights = nights;
        this.totalCost = this.totalCost();
    }

    public Bedroom getRoom() {
        return this.bedroom;
    }

    public int getNights() {
        return this.nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
        this.totalCost = this.totalCost();
    }

    private int totalCost() {
        return this.bedroom.getCost() * this.nights;
    }

    public int getTotalCost() {
        return this.totalCost;
    }
}
