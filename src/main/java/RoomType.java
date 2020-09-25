public enum RoomType {

    SINGLE(1, 25),
    DOUBLE(2, 40),
    TWIN(2, 40),
    FAMILY(4, 75),
    PENTHOUSE(2, 200);

    private final int capacity;
    private final int costPerNight;

    RoomType(int capacity, int costPerNight) {
        this.capacity = capacity;
        this.costPerNight = costPerNight;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCost() {
        return costPerNight;
    }
}
