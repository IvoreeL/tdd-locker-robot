package cn.xpbootcamp.gilded_rose;

import java.util.ArrayList;

public class LockerRobot {

    private ArrayList<Locker> inChargedLockers;

    public void inCharge(ArrayList<Locker> lockers) {
        this.inChargedLockers = lockers;
    }

    public Ticket save(Bag bag) throws LockerFullException {
        Locker availableLocker = inChargedLockers.stream()
                .filter(Locker::isAvailable)
                .findFirst().orElseThrow(LockerFullException::new);
        return availableLocker.save(bag);
    }

}
