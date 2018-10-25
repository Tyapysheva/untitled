package entity;

import java.time.LocalDateTime;

public interface Reservation {
    LocalDateTime timed();
    int row();
    int column();
    String userd();
}
