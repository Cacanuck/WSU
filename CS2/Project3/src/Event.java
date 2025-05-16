enum EventType {
    TRUCK_START,
    TRUCK_AT_CROSS,
    TRUCK_CROSS,
    TRUCK_END,
    TRAIN_BLOCK,
    TRAIN_NOT_BLOCK
}

public class Event implements Comparable<Event> {

    double time;
    EventType type;
    int truckId;

    public Event(double time, EventType type, int truckId) {
        this.time = time;
        this.type = type;
        this.truckId = truckId;
    }

    @Override
    public int compareTo(Event o) {
        return Double.compare(this.time, o.time);
    }
}
