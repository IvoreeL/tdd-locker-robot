package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;




class LockerRobotTest {

    private final static int NUMBER_ONE = 0;
    private final static int NUMBER_TWO = 1;

    @Test
    void should_get_a_ticket_and_the_bag_in_locker_1_when_save_a_bag_given_a_robot_with_two_empty_lockers() {
        LockerRobot lockerRobot = LockerRobotHelper.createDefaultLockerRobot();
        Bag bag = new Bag();
        Ticket ticket = lockerRobot.save(bag);
        Locker locker1 = LockerRobotHelper.getLocker(NUMBER_ONE);
        assertNotNull(ticket);
        assertTrue(locker1.hasBag(bag));
    }

    @Test
    void should_get_a_ticket_and_the_bag_in_locker_2_when_save_a_bag_given_a_robot_with_full_locker_and_empty_locker() {
        LockerRobot lockerRobot = LockerRobotHelper.createDefaultLockerRobot();
        lockerRobot.save(new Bag());
        Bag bag = new Bag();
        Ticket ticket = lockerRobot.save(bag);
        Locker locker2 = LockerRobotHelper.getLocker(NUMBER_TWO);
        assertNotNull(ticket);
        assertTrue(locker2.hasBag(bag));
    }

    @Test
    void should_get_two_tickets_and_bags_are_saved_in_order_given_a_robot_with_two_empty_lockers() {
        LockerRobot lockerRobot = LockerRobotHelper.createDefaultLockerRobot();
        Bag bag = new Bag();
        Bag anotherBag = new Bag();
        Ticket ticket = lockerRobot.save(bag);
        Ticket anotherTicket = lockerRobot.save(anotherBag);
        Locker locker1 = LockerRobotHelper.getLocker(NUMBER_ONE);
        Locker locker2 = LockerRobotHelper.getLocker(NUMBER_TWO);
        assertNotEquals(ticket, anotherTicket);
        assertTrue(locker1.hasBag(bag));
        assertTrue(locker2.hasBag(anotherBag));
    }

// given an invalid ticket when retrieves bag then user would get error message('票据无效').
// given an used ticket when retrieves bag then user would get error message('票据无效').
// given a robot who manages one full locker(capacity: 1, locker 1) and a empty locker(capacity: 1, locker 2) when retrieve the bag in locker 1 and save a bag then user would get a ticket and the bag would be saved in locker 1


    @Test
    void should_get_error_message_when_save_a_bag_given_a_robot_who_manages_2_full_lockers() {
        LockerRobot lockerRobot = LockerRobotHelper.createDefaultLockerRobot();
        lockerRobot.save(new Bag());
        lockerRobot.save(new Bag());
        assertThrows(LockerFullException.class, () -> lockerRobot.save(new Bag()), "柜子已满");
    }

    @Test
    void should_get_the_bag_when_user_retrieves_bag_given_a_valid_ticket() {
        LockerRobot lockerRobot = LockerRobotHelper.createDefaultLockerRobot();
        Bag savedBag = new Bag();
        Ticket ticket = lockerRobot.save(savedBag);
        Bag retrievedBag = lockerRobot.retrieve(ticket);
        assertEquals(savedBag, retrievedBag);
    }

    @Test
    void should_get_error_message_when_retrieves_bag_given_an_invalid_ticket() {
        LockerRobot lockerRobot = LockerRobotHelper.createDefaultLockerRobot();
        lockerRobot.save(new Bag());
        assertThrows(InvalidTicketException.class, ()->lockerRobot.retrieve(new Ticket()), "票据无效");
    }
}
