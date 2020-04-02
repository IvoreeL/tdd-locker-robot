package cn.xpbootcamp.gilded_rose;

class LockerFullException extends RuntimeException {
    public LockerFullException() {
        super("柜子已满!");
    }
}
