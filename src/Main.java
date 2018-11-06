import DAO.ResultSetIterator;
import entity.CinemaRoom;
import entity.Reservation;
import entity.ReservationEntity;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/reservation_cinema_place";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        ArrayList<Integer> p = new ArrayList<Integer>();
        ArrayList<Integer> m = new ArrayList<Integer>();


//        List n =Stream.of(-2,1, 2, -2, -2,2,10)
//                .collect(Collectors.partitioningBy(x->x>0,Collectors.summingInt(value -> value)))
//                .entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
//
//        System.out.println(n);


        Class.forName("org.postgresql.Driver");
        LocalDateTime localDateTime = LocalDateTime.now();
//
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
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            String nameRoom = resultSet.getString("name_room");
            Reservation r;
            Iterator<Reservation> s;
            s = new ResultSetIterator<Reservation>(resultSet, resultSet1 -> {
                try {
                    return new ReservationEntity(resultSet1
                            .getTimestamp("timed")
                            .toLocalDateTime(), resultSet1
                            .getInt("sequence_place"), resultSet1
                            .getString("userd"));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            });


         Spliterator<Reservation> spliterator = Spliterators.spliteratorUnknownSize(
                 s, Spliterator.NONNULL);
         Stream<Reservation> stream = StreamSupport.stream(spliterator, false);

         Map<String,List<Reservation>> map;
            map = stream.collect(Collectors.groupingBy());
            System.out.println(map);

         //   while (s.hasNext()) {



//               Map<String, List<Reservation>> reservationHM = new HashMap<String, List<Reservation>>();
//               List<Reservation> reservationList = new ArrayList<Reservation>();

//                String nameRoom = resultSet.getString("name_room");
//                Timestamp timed = resultSet.getTimestamp("timed");
//                String userd = resultSet.getString("userd");
//                int sequence = resultSet.getInt("sequence_place");
//                r = new ReservationEntity(timed.toLocalDateTime(), sequence, userd);
//                if (reservationHM.containsKey(nameRoom)) {
//                    reservationList = reservationHM.get(nameRoom);
//
//                } else {
//                    reservationList = new ArrayList<>();
//                    reservationHM.put(nameRoom, reservationList);
//                }
//                reservationList.add(r);
            }
//            for (Map.Entry<String, List<Reservation>> entry : reservationHM.entrySet()) {
//               // System.out.println(entry.getKey());
//                for (int i = 0; i < entry.getValue().size(); i++) {
//                   // System.out.println(entry.getValue().get(i));
//                }
      //  }
    }

}



