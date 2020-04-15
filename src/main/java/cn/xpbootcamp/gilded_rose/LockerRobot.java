package cn.xpbootcamp.gilded_rose;

import java.util.ArrayList;

public abstract class LockerRobot {

    protected ArrayList<Locker> inChargedLockers;

    protected void manage(ArrayList<Locker> lockers) {
        this.inChargedLockers = lockers;
    }

    protected Ticket save(Bag bag) {
        throw new RuntimeException();
    }

    protected Bag retrieve(Ticket ticket) {
        Locker storedLocker = inChargedLockers.stream()
                .filter(locker -> locker.hasTicket(ticket))
                .findFirst().orElseThrow(InvalidTicketException::new);
        return storedLocker.retrieve(ticket);
    }
}
