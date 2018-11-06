package entity;

import java.time.LocalDateTime;


public class ReservationEntity implements Reservation {
    private long id;
    private LocalDateTime timed;
    private String userd;
    private int sequence;
    private String nameRoom;



    public ReservationEntity( LocalDateTime time, int sequence, String userd,String nameRoom ) {
        this.timed = time;
        this.userd = userd;
        this.sequence = sequence;
        this.nameRoom = nameRoom;
    }
    public ReservationEntity() {
    }

    @Override
    public LocalDateTime timed() {
        return timed;
    }

    @Override
    public String userd() {
        return userd;
    }

    @Override
    public int sequence() {
        return sequence;
    }

    @Override
    public String nameRoom() {
        return nameRoom;
    }

    @Override
    public String toString() {
        return "\n\t\t"+"Посетитель: "+userd()+"\t|\tВремя: "+timed()+"\t|\tМесто: "+sequence()+"\n";
    }
}