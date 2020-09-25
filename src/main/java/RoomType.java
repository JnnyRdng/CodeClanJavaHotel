public enum RoomType {

    SINGLE(1),
    DOUBLE(2),
    TWIN(2),
    FAMILY(4),
    PENTHOUSE(2);

    private final int capacity;

    RoomType(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
