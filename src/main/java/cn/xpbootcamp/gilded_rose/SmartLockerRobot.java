package cn.xpbootcamp.gilded_rose;

import java.util.ArrayList;
import java.util.Comparator;

public class SmartLockerRobot implements LockerRobot{

    private ArrayList<Locker> inChargedLockers;

    public void manage(ArrayList<Locker> lockers) {
        this.inChargedLockers = lockers;
    }

    public Ticket save(Bag bag) {
        Locker availableLocker = inChargedLockers.stream()
                .max(Comparator.comparingInt(Locker::getAvailableSize))
                .orElseThrow(LockerFullException::new);
        return availableLocker.save(bag);
    }

    @Override
    public Bag retrieve(Ticket ticket) {
        return null;
    }
}
