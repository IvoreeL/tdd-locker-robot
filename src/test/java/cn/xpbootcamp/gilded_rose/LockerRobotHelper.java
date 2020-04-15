package cn.xpbootcamp.gilded_rose;

import java.util.ArrayList;

public class LockerRobotHelper {
    private LockerRobot lockerRobot;
    private static ArrayList<Locker> lockers;

    private LockerRobotHelper(LockerRobot lockerRobot){
        this.lockerRobot = lockerRobot ;
        lockers = new ArrayList<>();
    }

    public static LockerRobot createDefaultPrimaryLockerRobot() {
        LockerRobotHelper helper = new LockerRobotHelper(new PrimaryLockerRobot());
        return helper
                .withLocker(1)
                .withLocker(1)
                .build();
    }

    public static LockerRobotHelper createDefaultSmartLockerRobot() {
       return new LockerRobotHelper(new SmartLockerRobot());
    }

    public static LockerRobotHelper createDefaultSuperLockerRobot() {
        return new LockerRobotHelper(new SuperLockerRobot());
    }

    public LockerRobotHelper withLocker(int capacity){
        lockers.add(new Locker(capacity));
        return this;
    }

    public LockerRobot build(){
        lockerRobot.manage(lockers);
        return lockerRobot;
    }

    public static Locker getLocker(int lockerNumber){
        return lockers.get(lockerNumber);
    }
}
