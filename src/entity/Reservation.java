package entity;

import java.time.LocalDateTime;

public interface Reservation {
    LocalDateTime timed();
    String userd();
    int sequence();
    String nameRoom();
}
