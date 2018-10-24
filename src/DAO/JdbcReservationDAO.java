package DAO;

import entity.Reservation;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Supplier;


public class JdbcReservationDAO extends JdbcDAO implements ReservationDAO {


    public JdbcReservationDAO(Supplier<Connection> connectionSupplier) {
        super(connectionSupplier);
    }

    @Override
    public List<Reservation> getALL() throws SQLException {
        Connection connection = this.connectionSupplier.get();
        String sql;
        sql = "SELECT * FROM reservation";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet =statement.executeQuery(sql) ;

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            Time time = resultSet.getTime("time");
            int row = resultSet.getInt("row");
            int col = resultSet.getInt("col");
            String user = resultSet.getString("user");

        }
        resultSet.close();
        statement.close();
        connection.close();
        return null;
    }

    @Override
    public boolean reservPlace(Reservation r) throws SQLException {
        Connection connection = this.connectionSupplier.get();
        String sql;
        sql = "Update reservation SET user=? AND time=? WHERE row=? AND col=? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet =statement.executeQuery(sql) ;

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            Time time = resultSet.getTime("time");
            int row = resultSet.getInt("row");
            int col = resultSet.getInt("col");
            String user = resultSet.getString("user");

        }
        resultSet.close();
        statement.close();
        connection.close();
            return false;
        }
    }

