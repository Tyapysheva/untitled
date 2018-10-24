package entity;

import java.time.LocalDateTime;

public interface Reservation {
    LocalDateTime time();
    int row();
    int column();
    String user();
}
