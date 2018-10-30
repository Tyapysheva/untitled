package entity;

import java.time.LocalDateTime;


public class ReservationEntity implements Reservation {
    private long id;
    private LocalDateTime timed;
    private String userd;
    private int sequence;
    private CinemaRoom cinemaRoom;

    public ReservationEntity( LocalDateTime time, int sequence, String user) {
        this.timed = time;
        this.userd = user;
        this.sequence = sequence;

    }

    @Override
    public LocalDateTime timed() {
        return timed;
    }

    @Override
    public String userd() {
        return null;
    }

    @Override
    public int sequence() {
        return sequence;
    }

    @Override
    public CinemaRoom cinemaRoom() {
        return cinemaRoom;
    }


}