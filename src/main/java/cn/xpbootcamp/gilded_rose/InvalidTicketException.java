package cn.xpbootcamp.gilded_rose;

class InvalidTicketException extends Exception{
    public InvalidTicketException() {
        super("票据无效");
    }
}
