package cn.xpbootcamp.gilded_rose;

import java.util.ArrayList;

public interface LockerRobot {
    void manage(ArrayList<Locker> lockers);

    Ticket save(Bag bag);

    Bag retrieve(Ticket ticket);
}
