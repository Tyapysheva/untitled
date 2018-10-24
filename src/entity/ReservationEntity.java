package entity;

import java.time.LocalDateTime;


public class ReservationEntity implements Reservation {
    private int id;
    private LocalDateTime time;
    private int row;
    private int column;
    private String user;

    public ReservationEntity(int id, LocalDateTime time, int row, int column, String user) {
        this.id = id;
        this.time = time;
        this.row = row;
        this.column = column;
        this.user = user;
    }

    @Override
    public LocalDateTime time() {
        return time;
    }

    @Override
    public int row() {
        return row;
    }

    @Override
    public int column() {
        return column;
    }

    @Override
    public String user() {
        return user;
    }
}
