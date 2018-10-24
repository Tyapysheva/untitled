package DAO;

import java.sql.Connection;
import java.util.function.Supplier;

public abstract class JdbcDAO extends DAO {
    Supplier<Connection> connectionSupplier;

    public JdbcDAO(Supplier<Connection> connectionSupplier) {
        this.connectionSupplier = connectionSupplier;
    }


}
