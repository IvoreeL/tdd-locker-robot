package cn.xpbootcamp.gilded_rose;

import java.util.ArrayList;

public class LockerRobot {

    private ArrayList<Locker> inChargedLockers;

    public void inCharge(ArrayList<Locker> lockers) {
        this.inChargedLockers = lockers;
    }

    public Ticket save(Bag bag) {
        Locker availableLocker = inChargedLockers.stream()
                .filter(Locker::isAvailable)
                .findFirst().orElseThrow(LockerFullException::new);
        return availableLocker.save(bag);
    }

    public Bag retrieve(Ticket ticket) {
        Locker storedLocker = inChargedLockers.stream()
                .filter(locker -> locker.hasTicket(ticket))
                .findFirst().orElseThrow(InvalidTicketException::new);
        return storedLocker.retrieve(ticket);
    }
}
