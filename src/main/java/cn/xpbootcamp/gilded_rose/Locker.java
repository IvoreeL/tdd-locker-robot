package cn.xpbootcamp.gilded_rose;



import java.util.HashMap;
import java.util.Map;

public class Locker {

    private Map<Ticket, Bag> storage = new HashMap<>();
    private int size;

    public Locker(int size) {
        this.size = size;
    }

    public Ticket saveBag(Bag bag) throws LockerFullException {
        if (storage.size() >= size){
            throw new LockerFullException();
        }
        Ticket ticket = new Ticket();
        storage.put(ticket, bag);
        return ticket;
    }

    public Bag retrieveBag(Ticket ticket) throws InvalidTicketException {
        if (!storage.containsKey(ticket)){
            throw new InvalidTicketException();
        }
        return storage.remove(ticket);
    }
}
