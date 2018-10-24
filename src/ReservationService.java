import DAO.JdbcReservationDAO;
import entity.Reservation;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Supplier;

public class ReservationService extends JdbcReservationDAO {

    public ReservationService(Supplier<Connection> connectionSupplier) {
        super(connectionSupplier);
    }

    @Override
    public List<Reservation> getALL() throws SQLException {

        return super.getALL();
    }
}
