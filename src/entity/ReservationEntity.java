package entity;

import java.time.LocalDateTime;


public class ReservationEntity implements Reservation {
    private int id;
    private LocalDateTime timed;
    private int row;
    private int column;
    private String userd;

    public ReservationEntity(int id, LocalDateTime time, int row, int column, String user) {
        this.id = id;
        this.timed = time;
        this.row = row;
        this.column = column;
        this.userd = user;
    }

    @Override
    public LocalDateTime timed() {
        return timed;
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
    public String userd() {
        return userd;
    }
}
