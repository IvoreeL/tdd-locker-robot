package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

// given a robot who manages two empty lockers(capacity: 1) when save a bag then user would get a ticket and the bag would be saved in locker 1
// given a robot who manages one full locker(capacity: 1, locker 1) and a empty locker(capacity: 1, locker 2) when save a bag then user would get a ticket and the bag would be saved in locker 2
// given a robot who manages two empty lockers(capacity: 1) when save two bags then user would get two different tickets and the bags would be saved in order.
// given a robot who manages two full lockers(capacity: 1) when save a bag the user would get an error message.
// given a valid ticket when retrieves bag then user would get the bag.
// given an invalid ticket when retrieves bag then user would get error message('票据无效').
// given an used ticket when retrieves bag then user would get error message('票据无效').
// given a robot who manages one full locker(capacity: 1, locker 1) and a empty locker(capacity: 1, locker 2) when retrieve the bag in locker 1 and save a bag then user would get a ticket and the bag would be saved in locker 1

class LockerRobotTest {
    @Test
    void should_get_a_ticket_and_the_bag_in_locker_1_when_save_a_bag_given_a_robot_with_two_empty_lockers() throws LockerFullException {
        LockerRobot lockerRobot = new LockerRobot();
        ArrayList<Locker> lockers = new ArrayList<>();
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(1);
        Bag bag = new Bag();
        lockers.add(locker1);
        lockers.add(locker2);
        lockerRobot.inCharge(lockers);
        Ticket ticket = lockerRobot.save(bag);
        assertNotNull(ticket);
        assertTrue(locker1.contains(bag));
    }
}
