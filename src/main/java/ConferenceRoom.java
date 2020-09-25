public class ConferenceRoom extends Room {


    private String name;

    public ConferenceRoom(String name, int capacity) {
        super(capacity);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
