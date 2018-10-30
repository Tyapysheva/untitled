package DAO;

import entity.Reservation;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface ReservationDAO{
    Map<String,List<Reservation>> getALL() throws SQLException;
    boolean reservPlace(Reservation r) throws SQLException;

}
