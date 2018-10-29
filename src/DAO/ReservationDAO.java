package DAO;

import entity.Reservation;

import java.sql.SQLException;
import java.util.List;


public interface ReservationDAO{
    List<Reservation> getALL() throws SQLException;
    boolean reservPlace(Reservation r) throws SQLException;

}
