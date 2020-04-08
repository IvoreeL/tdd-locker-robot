package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimaryLockerRobotTest {

    private final static int NUMBER_ONE = 0;
    private final static int NUMBER_TWO = 1;


    @Test
    void should_get_a_ticket_and_the_bag_in_locker_1_when_save_a_bag_given_a_robot_with_two_empty_lockers() {
        PrimaryLockerRobot primaryLockerRobot = (PrimaryLockerRobot) LockerRobotHelper.createDefaultPrimaryLockerRobot();
        Bag bag = new Bag();
        Ticket ticket = primaryLockerRobot.save(bag);
        Locker locker1 = LockerRobotHelper.getLocker(NUMBER_ONE);
        assertNotNull(ticket);
        assertTrue(locker1.hasBag(bag));
    }

    @Test
    void should_get_a_ticket_and_the_bag_in_locker_2_when_save_a_bag_given_a_robot_with_full_locker_and_empty_locker() {
        PrimaryLockerRobot primaryLockerRobot = (PrimaryLockerRobot) LockerRobotHelper.createDefaultPrimaryLockerRobot();
        primaryLockerRobot.save(new Bag());
        Bag bag = new Bag();
        Ticket ticket = primaryLockerRobot.save(bag);
        Locker locker2 = LockerRobotHelper.getLocker(NUMBER_TWO);
        assertNotNull(ticket);
        assertTrue(locker2.hasBag(bag));
    }

    @Test
    void should_get_two_tickets_and_bags_are_saved_in_order_given_a_robot_with_two_empty_lockers() {
        PrimaryLockerRobot primaryLockerRobot = (PrimaryLockerRobot) LockerRobotHelper.createDefaultPrimaryLockerRobot();
        Bag bag = new Bag();
        Bag anotherBag = new Bag();
        Ticket ticket = primaryLockerRobot.save(bag);
        Ticket anotherTicket = primaryLockerRobot.save(anotherBag);
        Locker locker1 = LockerRobotHelper.getLocker(NUMBER_ONE);
        Locker locker2 = LockerRobotHelper.getLocker(NUMBER_TWO);
        assertNotEquals(ticket, anotherTicket);
        assertTrue(locker1.hasBag(bag));
        assertTrue(locker2.hasBag(anotherBag));
    }

    @Test
    void should_get_error_message_when_save_a_bag_given_a_robot_who_manages_2_full_lockers() {
        PrimaryLockerRobot primaryLockerRobot = (PrimaryLockerRobot) LockerRobotHelper.createDefaultPrimaryLockerRobot();
        primaryLockerRobot.save(new Bag());
        primaryLockerRobot.save(new Bag());
        assertThrows(LockerFullException.class, () -> primaryLockerRobot.save(new Bag()), "柜子已满");
    }

    @Test
    void should_get_the_bag_when_user_retrieves_bag_given_a_valid_ticket() {
        PrimaryLockerRobot primaryLockerRobot = (PrimaryLockerRobot) LockerRobotHelper.createDefaultPrimaryLockerRobot();
        Bag savedBag = new Bag();
        Ticket ticket = primaryLockerRobot.save(savedBag);
        Bag retrievedBag = primaryLockerRobot.retrieve(ticket);
        assertEquals(savedBag, retrievedBag);
    }

    @Test
    void should_get_error_message_when_retrieves_bag_given_an_invalid_ticket() {
        PrimaryLockerRobot primaryLockerRobot = (PrimaryLockerRobot) LockerRobotHelper.createDefaultPrimaryLockerRobot();
        primaryLockerRobot.save(new Bag());
        assertThrows(InvalidTicketException.class, () -> primaryLockerRobot.retrieve(new Ticket()), "票据无效");
    }

    @Test
    void should_get_error_message_when_retrieves_bag_given_an_used_ticket() {
        PrimaryLockerRobot primaryLockerRobot = (PrimaryLockerRobot) LockerRobotHelper.createDefaultPrimaryLockerRobot();
        Ticket ticket = primaryLockerRobot.save(new Bag());
        primaryLockerRobot.retrieve(ticket);
        assertThrows(InvalidTicketException.class, () -> primaryLockerRobot.retrieve(ticket), "票据无效");
    }

    @Test
    void should_save_bag_in_locker1_when_save_bag_after_retrieve_given_robot_with_one_full_and_one_empty() {
        PrimaryLockerRobot primaryLockerRobot = (PrimaryLockerRobot) LockerRobotHelper.createDefaultPrimaryLockerRobot();
        Ticket ticket = primaryLockerRobot.save(new Bag());
        primaryLockerRobot.retrieve(ticket);
        Bag bag = new Bag();
        primaryLockerRobot.save(bag);
        Locker locker1 = LockerRobotHelper.getLocker(NUMBER_ONE);
        assertTrue(locker1.hasBag(bag));
    }
}
