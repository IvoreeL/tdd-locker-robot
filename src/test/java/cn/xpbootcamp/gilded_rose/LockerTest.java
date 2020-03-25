package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LockerTest {

    private final int DEFAULT_LOCKER_SIZE = 19;

    @Test
    void should_get_a_ticket_given_an_empty_locker_when_save_bag() throws LockerFullException {
        Locker locker = new Locker(DEFAULT_LOCKER_SIZE);
        Bag bag = new Bag();
        Ticket ticket = locker.saveBag(bag);
        assertNotNull(ticket);
    }

    @Test
    void should_get_a_ticket_given_a_locker_with_one_empty_room_when_save_bag() throws LockerFullException {
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        Ticket ticket = locker.saveBag(bag);
        assertNotNull(ticket);
    }

    @Test
    void should_get_a_ticket_given_a_locker_with_one_empty_room_when_save_nothing() throws LockerFullException {
        Locker locker = new Locker(DEFAULT_LOCKER_SIZE);
        Bag nothing = null;
        Ticket ticket = locker.saveBag(nothing);
        assertNotNull(ticket);
    }

    @Test
    void should_get_an_error_message_given_a_full_locker_when_save_bag() {
        Locker locker = new Locker(0);
        Bag bag = new Bag();
        String errorMessage = "柜子已满!";
        assertThrows(LockerFullException.class, ()->locker.saveBag(bag), errorMessage);
    }

    @Test
    void should_get_the_bag_given_a_valid_ticket_when_retrieve_bag() throws LockerFullException {
        Locker locker = new Locker(DEFAULT_LOCKER_SIZE);
        Bag savedBag = new Bag();
        Ticket ticket = locker.saveBag(savedBag);
        Bag retrievedBag = locker.retrieveBag(ticket);
        assertSame(savedBag,retrievedBag);
    }
}
