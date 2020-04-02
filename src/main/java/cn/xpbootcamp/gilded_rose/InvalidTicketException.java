package cn.xpbootcamp.gilded_rose;

class InvalidTicketException extends RuntimeException{
    public InvalidTicketException() {
        super("票据无效");
    }
}
