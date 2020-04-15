package cn.xpbootcamp.gilded_rose;


public class PrimaryLockerRobot extends LockerRobot{

    @Override
    public Ticket save(Bag bag) {
        Locker availableLocker = super.inChargedLockers.stream()
                .filter(Locker::isAvailable)
                .findFirst().orElseThrow(LockerFullException::new);
        return availableLocker.save(bag);
    }
}
