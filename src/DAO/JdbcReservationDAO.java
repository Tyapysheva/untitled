package DAO;

import entity.CinemaRoom;
import entity.CinemaRoomEntity;
import entity.Reservation;
import entity.ReservationEntity;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


public class JdbcReservationDAO extends JdbcDAO implements ReservationDAO {

    LocalDateTime localDateTime = LocalDateTime.now();
    Reservation r;
    public JdbcReservationDAO(Supplier<Connection> connectionSupplier) {
        super(connectionSupplier);
    }

    @Override
    public List<Reservation> getALL() throws SQLException {

        List<Reservation> reservationList =new ArrayList<Reservation>();
        String sql = "SELECT * FROM reservation";
        try (Connection connection = this.connectionSupplier.get();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Timestamp timed = resultSet.getTimestamp("timed");
                String userd = resultSet.getString("userd");
                int sequence = resultSet.getInt("sequence_place");
                String nameRoom = resultSet.getString("name_room");
                int row = resultSet.getInt("total_row");
                int col = resultSet.getInt("total_col");
                r = new ReservationEntity(timed.toLocalDateTime(), sequence, new CinemaRoomEntity(nameRoom,row,col), userd);
                reservationList.add(r);
            }
            return reservationList;
        }
    }

    @Override
    public boolean reservPlace(Reservation r) throws SQLException {

        String sql1 = "SELECT userd FROM reservation WHERE row=? AND col=?";
        String sql2 = "Update reservation SET userd =?, timed =? WHERE row=? AND col=?";

        try (Connection connection = this.connectionSupplier.get();
             PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
             PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
             ResultSet resultSet = preparedStatement1.executeQuery()) {
           // preparedStatement1.setInt(1, r.row());
           // preparedStatement1.setInt(2, r.column());
            while (resultSet.next()) {

                if (resultSet.getString("userd") == null) {
                    preparedStatement2.setString(1, r.userd());
                    preparedStatement2.setTimestamp(2, Timestamp.valueOf(r.timed()));
                  //  preparedStatement2.setInt(3, r.row());
                  //  preparedStatement2.setInt(4, r.column());
                    preparedStatement2.executeUpdate();
                }
            }
            return true;
        }
    }

}


