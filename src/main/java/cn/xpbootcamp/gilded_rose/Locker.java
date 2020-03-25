package cn.xpbootcamp.gilded_rose;



import java.util.HashMap;
import java.util.Map;

public class Locker {

    private Map<Ticket, Bag> storage = new HashMap<>();
    private int size;

    public Locker(int size) {
        this.size = size;
    }

    public Locker() {
        this(19);
    }

    public Ticket saveBag(Bag bag) {
        Ticket ticket = new Ticket();
        storage.put(ticket, bag);
        return ticket;
    }
}
