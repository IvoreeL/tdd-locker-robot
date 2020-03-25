package cn.xpbootcamp.gilded_rose;

class LockerFullException extends Exception {
    public LockerFullException() {
        super("柜子已满!");
    }
}
