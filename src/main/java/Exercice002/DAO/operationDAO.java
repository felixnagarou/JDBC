package Exercice002.DAO;

import Exercice002.Model.Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class operationDAO extends BaseDAO<Operation> {
    protected operationDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Operation element) throws SQLException {
        query = "INSERT into operation (amount, status, accountId) VALUES ( ?, ?, ?)";
        statement = _connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setDouble(1, element.getAmount());
        statement.setBoolean(2, element.getStatus());
        int nbRows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            element.setNumber(resultSet.getInt(1));
        }
        return nbRows == 1;
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
        List<Operation> result = new ArrayList<>();
        query = "SELECT * from operation";
        statement = _connection.prepareStatement(query);
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            Operation operation = new Operation(resultSet.getInt("operationId"),
                    resultSet.getFloat("amount"),
                    resultSet.getBoolean("status"),
                    resultSet.getInt("accountId"));
            result.add(operation);
        }
        return result;
    }

}
