import DAO.JdbcDAO;
import DAO.JdbcReservationDAO;
import entity.Reservation;
import entity.ReservationEntity;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/reservation_cinema_place";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        LocalDateTime localDateTime = LocalDateTime.now();

//        String sql1 = "SELECT * FROM reservation_cinema          WHERE EXISTS\n" +
//                "                      ( SELECT *\n" +
//                "                          FROM reservation\n" +
//                "                          WHERE sequence_place = 2 );";
//
//
//        String sql2 = "Insert into reservation (timed, userd, sequence_place, id_cinema_room) values (?,?,?,?)";
//
//        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
//             PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
//             PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
//             ResultSet resultSet = preparedStatement1.executeQuery())
//        {
//            while (resultSet.next()) {
//                int totalReserv = resultSet.getInt("total_reserv");
//                String nameRoom = resultSet.getString("name_room");
//                int total_place = resultSet.getInt("total_place");
//                if (totalReserv > total_place) {
//                    {
//                        preparedStatement2.setTimestamp(1, Timestamp.valueOf(localDateTime));
//                        preparedStatement2.setString(2, "Borsh");
//                        preparedStatement2.setInt(3, 4);
//                        preparedStatement2.setInt(4, 1);
//                        preparedStatement2.executeUpdate();
//                   }
//                }
//            }
//        }




        String sql = "SELECT timed,userd, sequence_place, name_room" +
                " FROM reservation INNER JOIN cinema_room ON reservation.id_cinema_room=cinema_room.id";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            Reservation r;
            Map<String, List<Reservation>> reservationHM = new HashMap<String, List<Reservation>>();

            while (resultSet.next()) {
                List<Reservation> reservationList = new ArrayList<Reservation>();
                String nameRoom = resultSet.getString("name_room");
                Timestamp timed = resultSet.getTimestamp("timed");
                String userd = resultSet.getString("userd");
                int sequence = resultSet.getInt("sequence_place");
                r = new ReservationEntity(timed.toLocalDateTime(), sequence, userd);
                if (reservationHM.containsKey(nameRoom)) {
                    reservationList = reservationHM.get(nameRoom);

                } else {
                    reservationList = new ArrayList<>();
                    reservationHM.put(nameRoom, reservationList);
                }
                reservationList.add(r);
            }
            for (Map.Entry<String, List<Reservation>> entry : reservationHM.entrySet()) {
                System.out.println(entry.getKey());
                for (int i = 0; i < entry.getValue().size(); i++) {
                    System.out.println(entry.getValue().get(i));
                }
            }
        }
    }

}
