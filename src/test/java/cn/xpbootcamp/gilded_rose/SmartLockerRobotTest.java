package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartLockerRobotTest {
    private final static int NUMBER_ONE = 0;
    private final static int NUMBER_TWO = 1;

    @Test
    void should_get_ticket_and_the_bag_would_saved_in_locker_1_when_save_bag_given_a_robot_with_two_empty_lockers() {
        SmartLockerRobot smartLockerRobot = (SmartLockerRobot) LockerRobotHelper.createDefaultSmartLockerRobot()
                                                                                .withLocker(1)
                                                                                .withLocker(1)
                                                                                .build();
        Bag bag = new Bag();
        Ticket ticket = smartLockerRobot.save(bag);
        assertNotNull(ticket);
        Locker locker1 = LockerRobotHelper.getLocker(NUMBER_ONE);
        assertTrue(locker1.hasBag(bag));
    }

    @Test
    void should_get_two_different_tickets_when_save_two_bags_given_a_robot_with_two_empty_lockers() {
        SmartLockerRobot smartLockerRobot = (SmartLockerRobot) LockerRobotHelper.createDefaultSmartLockerRobot()
                .withLocker(1)
                .withLocker(1)
                .build();
        Ticket ticket = smartLockerRobot.save(new Bag());
        Ticket anotherTicket = smartLockerRobot.save(new Bag());
        assertNotEquals(ticket, anotherTicket);
    }

    @Test
    void should_save_the_bag_in_locker2_when_save_bag_given_a_robot_with_two_different_lockers() {
        SmartLockerRobot smartLockerRobot = (SmartLockerRobot) LockerRobotHelper.createDefaultSmartLockerRobot()
                .withLocker(1)
                .withLocker(2)
                .build();
        Bag bag = new Bag();
        smartLockerRobot.save(bag);
        Locker locker2 = LockerRobotHelper.getLocker(NUMBER_TWO);
        assertTrue(locker2.hasBag(bag));
    }

//    given a robot which manages two full lockers(capacity: 1) when user saves a bag then the user would get an error message('柜子已满')
//    given a valid ticket when retrieves bag then user would get the bag.
//    given an invalid ticket when retrieves bag then user would get error message('票据无效').
//    given an used ticket when retrieves bag then user would get error message('票据无效').


    @Test
    void should_save_the_bag_in_locker1_when_save_bag_given_a_robot_with_empty_locker_and_full_locker() {
        SmartLockerRobot smartLockerRobot = (SmartLockerRobot) LockerRobotHelper.createDefaultSmartLockerRobot()
                .withLocker(1)
                .withLocker(1)
                .build();

        Ticket ticket = smartLockerRobot.save(new Bag());
        smartLockerRobot.save(new Bag());
        smartLockerRobot.retrieve(ticket);
        Bag bag = new Bag();
        smartLockerRobot.save(bag);
        Locker locker1 = LockerRobotHelper.getLocker(NUMBER_ONE);
        assertTrue(locker1.hasBag(bag));
    }

    @Test
    void should_get_error_message_when_save_bag_given_a_robot_with_two_full_lockers() {
        SmartLockerRobot smartLockerRobot = (SmartLockerRobot) LockerRobotHelper.createDefaultSmartLockerRobot()
                .withLocker(1)
                .withLocker(1)
                .build();
        smartLockerRobot.save(new Bag());
        smartLockerRobot.save(new Bag());
        assertThrows(LockerFullException.class, ()->smartLockerRobot.save(new Bag()), "柜子已满");
    }
}
