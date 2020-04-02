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

    private final static int NUMBER_ONE = 0;
    private final static int NUMBER_TWO = 1;

    @Test
    void should_get_a_ticket_and_the_bag_in_locker_1_when_save_a_bag_given_a_robot_with_two_empty_lockers() throws LockerFullException {
        LockerRobot lockerRobot = LockerRobotHelper.createDefaultLockerRobot();
        Bag bag = new Bag();
        Ticket ticket = lockerRobot.save(bag);
        Locker locker1 = LockerRobotHelper.getLocker(NUMBER_ONE);
        assertNotNull(ticket);
        assertTrue(locker1.contains(bag));
    }

    @Test
    void should_get_a_ticket_and_the_bag_in_locker_2_when_save_a_bag_given_a_robot_with_full_locker_and_empty_locker() throws LockerFullException {
        LockerRobot lockerRobot = LockerRobotHelper.createDefaultLockerRobot();
        Bag bag = new Bag();
        Bag anotherBag = new Bag();
        lockerRobot.save(bag);
        Ticket ticket = lockerRobot.save(anotherBag);
        Locker locker2 = LockerRobotHelper.getLocker(NUMBER_TWO);
        assertNotNull(ticket);
        assertTrue(locker2.contains(anotherBag));
    }
}
