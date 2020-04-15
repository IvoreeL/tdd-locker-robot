package cn.xpbootcamp.gilded_rose;
import java.util.Comparator;

public class SuperLockerRobot extends LockerRobot {

    @Override
    public Ticket save(Bag bag) {
        Locker availableLocker = super.inChargedLockers.stream()
                .max(Comparator.comparingDouble(Locker::getAvailableRatio))
                .filter(Locker::isAvailable)
                .orElseThrow(LockerFullException::new);
        return availableLocker.save(bag);
    }
}
