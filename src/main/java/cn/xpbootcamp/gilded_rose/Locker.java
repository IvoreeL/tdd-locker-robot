package cn.xpbootcamp.gilded_rose;



import java.util.HashMap;
import java.util.Map;

public class Locker {

    private Map<Ticket, Bag> storage = new HashMap<>();
    private int capacity;

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Ticket save(Bag bag) {
        if (!isAvailable()){
            throw new LockerFullException();
        }
        Ticket ticket = new Ticket();
        storage.put(ticket, bag);
        return ticket;
    }

    public Bag retrieve(Ticket ticket){
        if (!hasTicket(ticket)){
            throw new InvalidTicketException();
        }
        return storage.remove(ticket);
    }

    public boolean hasBag(Bag bag) {
        return storage.containsValue(bag);
    }

    public boolean isAvailable() {
        return storage.size() < capacity;
    }

    public boolean hasTicket(Ticket ticket) {
        return storage.containsKey(ticket);
    }

    public int getAvailableSize() {
        return capacity - storage.size();
    }
}
