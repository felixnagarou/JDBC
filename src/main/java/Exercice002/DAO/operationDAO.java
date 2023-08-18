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
        statement.setDouble(1, element.getAmount());
        statement.setInt(2, element.getNumber());
        int nbRow = statement.executeUpdate();
        return nbRow ==1;
    }

    @Override
    public boolean delete(Operation element) throws SQLException {
        query = "DELETE FROM operation where id = ?";
        statement = _connection.prepareStatement(query);
        statement.setInt(1, element.getNumber());
        int nbRow = statement.executeUpdate();
        return nbRow ==1;
    }

    @Override
    public Operation get(int id) throws SQLException {
        Operation operation = null;
        query = "SELECT FROM operation where id = ?";
        statement = _connection.prepareStatement(query);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if(resultSet.next()){
            operation = new Operation(resultSet.getInt("operationId"),
                    resultSet.getFloat("amount"),
                    resultSet.getBoolean("status"),
                    resultSet.getInt("accountId"));

        }

        return operation;
    }

    @Override
    public List<Operation> get() throws SQLException {
        return null;
    }

}
