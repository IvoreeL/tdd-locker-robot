package cn.xpbootcamp.gilded_rose;


import net.bytebuddy.implementation.bind.annotation.Super;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


//given a robot which manages two empty lockers(capacity: 1) when user saves a bag then the user would get a ticket and then the bag would be saved in locker 1
//given a robot which manages two lockers(locker 1 capacity: 2 saved 1, locker 2 capacity: 1) when user saves a bag then the user would get a ticket and then the bag would be saved in locker 2
//given a robot which manages two full lockers(capacity: 1) when user saves a bag then the user would get an error message('柜子已满')
//given a valid ticket when retrieves bag then user would get the bag.
//given an invalid ticket when retrieves bag then user would get error message('票据无效').
//given an used ticket when retrieves bag then user would get error message('票据无效').

class SuperLockerRobotTest {

    private final static int NUMBER_ONE = 0;
    private final static int NUMBER_TWO = 1;

    @Test
    void should_get_ticket_when_saving_bag_given_a_robot_with_two_empty_lockers() {
        SuperLockerRobot superLockerRobot = (SuperLockerRobot) LockerRobotHelper.createDefaultSuperLockerRobot()
                .withLocker(1)
                .withLocker(1)
                .build();
        Bag bag = new Bag();
        Ticket ticket = superLockerRobot.save(bag);
        assertNotNull(ticket);
        Locker locker1 = LockerRobotHelper.getLocker(NUMBER_ONE);
        assertTrue(locker1.hasBag(bag));
    }
}
