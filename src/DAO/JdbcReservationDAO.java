package DAO;

import entity.CinemaRoom;
import entity.CinemaRoomEntity;
import entity.Reservation;
import entity.ReservationEntity;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;


public class JdbcReservationDAO extends JdbcDAO implements ReservationDAO {

    LocalDateTime localDateTime = LocalDateTime.now();
    Reservation r;
    public JdbcReservationDAO(Supplier<Connection> connectionSupplier) {
        super(connectionSupplier);
    }

    @Override
    public Map<String, List<Reservation>> getALL() throws SQLException {
        List<Reservation> reservationList =new ArrayList<Reservation>();
        Map<String, List<Reservation>> reservationHM =new HashMap<String, List<Reservation>>();


        String sql = "SELECT timed,userd, sequence_place, name_room "+
                " FROM reservation INNER JOIN cinema_room ON reservation.id_cinema_room=cinema_room.id ";

        try (Connection connection = this.connectionSupplier.get();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String nameRoom = resultSet.getString("name_room");
                Timestamp timed = resultSet.getTimestamp("timed");
                String userd = resultSet.getString("userd");
                int sequence = resultSet.getInt("sequence_place");
                r = new ReservationEntity(timed.toLocalDateTime(), sequence, userd);
                if(reservationHM.containsKey(nameRoom)) {

                    reservationHM.get(nameRoom).add(r);
                }
                else
                {
                    reservationHM.put(nameRoom, reservationList);
                }

            }
            return reservationHM;
        }
    }

    @Override
    public boolean reservPlace(Reservation r) throws SQLException {


        String sql2 = "Insert into reservation (timed, userd, sequence_place, id_cinema_room) values (?,?,?,?)";

        try (Connection connection = this.connectionSupplier.get();
             PreparedStatement preparedStatement2 = connection.prepareStatement(sql2)) {
           // preparedStatement1.setInt(1, r.row());
           // preparedStatement1.setInt(2, r.column());

            preparedStatement2.setTimestamp(1, Timestamp.valueOf(localDateTime));
            preparedStatement2.setString(2, "Borsh");
            preparedStatement2.setInt(3, 1);
            preparedStatement2.setInt(4, 1);
            preparedStatement2.executeUpdate();
            return true;
        }
    }

}


