package Exercice002.DAO;

import Exercice002.Model.Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class operationDAO extends BaseDAO<Operation> {
    protected operationDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Operation element) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Operation element) throws SQLException {
        query = "UPDATE operation SET amount = ? WHERE id = ?";
        statement = _connection.prepareStatement(query);
        statement.setDouble(_connection.prepareStatement(1, ))


        return false;
    }

    @Override
    public boolean delete(Operation element) throws SQLException {
        return false;
    }

    @Override
    public Operation get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Operation> get() throws SQLException {
        return null;
    }

}
