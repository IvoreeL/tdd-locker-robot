package cn.xpbootcamp.gilded_rose;

import java.util.ArrayList;

public class LockerRobotHelper {
    private LockerRobot lockerRobot;
    private static ArrayList<Locker> lockers;

    private LockerRobotHelper(){
        lockerRobot = new LockerRobot();
    }

    public static LockerRobot createDefaultLockerRobot() {
        LockerRobotHelper helper = new LockerRobotHelper();
        return helper.withDefaultLockers().build();
    }

    private LockerRobotHelper withDefaultLockers(){
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(1);
        lockers = new ArrayList<>();
        lockers.add(locker1);
        lockers.add(locker2);
        lockerRobot.setInChargedLockers(lockers);
        return this;
    }

    private LockerRobot build(){
        return lockerRobot;
    }

    public static Locker getLocker(int lockerNumber){
        return lockers.get(lockerNumber);
    }
}
