package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LockerTest {

    private final int DEFAULT_LOCKER_CAPACITY = 19;

    @Test
    void should_get_a_ticket_when_save_bag_given_an_empty_locker() {
        Locker locker = new Locker(DEFAULT_LOCKER_CAPACITY);
        Bag bag = new Bag();
        Ticket ticket = locker.save(bag);
        assertNotNull(ticket);
    }

    @Test
    void should_get_two_different_tickets_when_user_save_twice_given_empty_locker() {
        Locker locker = new Locker(DEFAULT_LOCKER_CAPACITY);
        Bag bag = new Bag();
        Bag anotherBag = new Bag();
        Ticket ticket = locker.save(bag);
        Ticket anotherTicket = locker.save(anotherBag);
        assertNotEquals(ticket, anotherTicket);
    }

    @Test
    void should_get_an_error_message_when_save_bag_given_a_full_locker(){
        Locker locker = new Locker(1);
        Bag bag = new Bag();
        locker.save(bag);
        String errorMessage = "柜子已满!";
        assertThrows(LockerFullException.class, ()->locker.save(bag), errorMessage);
    }

    @Test
    void should_get_the_bag_when_retrieve_bag_given_a_valid_ticket() {
        Locker locker = new Locker(DEFAULT_LOCKER_CAPACITY);
        Bag savedBag = new Bag();
        Ticket ticket = locker.save(savedBag);
        Bag retrievedBag = locker.retrieve(ticket);
        assertSame(savedBag,retrievedBag);
    }

    @Test
    void should_get_error_message_when_retrieve_bag_given_an_invalid_ticket(){
        Locker locker = new Locker(DEFAULT_LOCKER_CAPACITY);
        Bag savedBag = new Bag();
        locker.save(savedBag);
        String errorMessage = "票据无效";
        assertThrows(InvalidTicketException.class, ()->locker.retrieve(new Ticket()), errorMessage);
    }

    @Test
    void should_get_error_message_when_retrieve_bag_given_an_used_ticket() {
        Locker locker = new Locker(DEFAULT_LOCKER_CAPACITY);
        Bag savedBag = new Bag();
        Ticket ticket = locker.save(savedBag);
        Bag retrievedBag = locker.retrieve(ticket);
        String errorMessage = "票据无效";
        assertSame(savedBag,retrievedBag);
        assertThrows(InvalidTicketException.class, ()->locker.retrieve(ticket), errorMessage);
    }
}
