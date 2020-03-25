package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class LockerTest {

    @Test
    void should_get_a_ticket_given_an_empty_locker_when_save_bag() {
        final Locker locker = new Locker();
        final Bag bag = new Bag();
        Ticket ticket = locker.saveBag(bag);
        assertNotNull(ticket);
    }

    @Test
    void should_get_a_ticket_given_a_locker_with_one_empty_room_when_save_bag() {
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        Ticket ticket = locker.saveBag(bag);
        assertNotNull(ticket);
    }
}
