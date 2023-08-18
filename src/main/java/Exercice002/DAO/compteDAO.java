package Exercice002.DAO;

import Exercice002.Model.Client;
import Exercice002.Model.CompteBancaire;
import Exercice002.Model.Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class compteDAO extends BaseDAO<CompteBancaire>{

    protected compteDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(CompteBancaire element) throws SQLException {
        query = "INSERT into account (solde, clientId) VALUES ( ?, ?)";
        statement = _connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setDouble(1, element.getSolde());
        statement.setInt(2, element.getClientId());
        int nbRows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            element.setAccountId(resultSet.getInt(1));
        }
        return nbRows == 1;
    }

    @Override
    public boolean update(CompteBancaire element) throws SQLException {
        query = "UPDATE account SET solde = ? WHERE id = ?";
        statement = _connection.prepareStatement(query);
        statement.setDouble(1, element.getSolde());
        statement.setInt(2, element.getAccountId());
        int nbRow = statement.executeUpdate();
        return nbRow ==1;
    }

    @Override
    public boolean delete(CompteBancaire element) throws SQLException {
        query = "DELETE FROM account where id = ?";
        statement = _connection.prepareStatement(query);
        statement.setInt(1, element.getAccountId());
        int nbRow = statement.executeUpdate();
        return nbRow ==1;
    }

    @Override
    public CompteBancaire get(int id) throws SQLException {
        CompteBancaire account = null;
        query = "SELECT FROM account where id = ?";
        statement = _connection.prepareStatement(query);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if(resultSet.next()){
            account = new CompteBancaire(resultSet.getInt("accountId"),
                    resultSet.getDouble("solde"),
                    resultSet.getInt("clientId"));
        }
        return account;
    }

    @Override
    public List<CompteBancaire> get() throws SQLException {
        List<CompteBancaire> result = new ArrayList<>();
        query = "SELECT * from account";
        statement = _connection.prepareStatement(query);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            CompteBancaire account = new CompteBancaire(resultSet.getInt("accountId"),
                    resultSet.getDouble("solde"),
                    resultSet.getInt("clientId"));
            result.add(account);
        }
        return result;
    }

    public CompteBancaire getAccountOperations() throws SQLException {
        CompteBancaire accountHistory = null;
        query = "SELECT * from operation JOIN account on operation.operationId = account.operationId  WHERE accountId = ?";
        statement = _connection.prepareStatement(query);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            accountHistory.setOperationList(resultSet.getInt("operationId"),
                    resultSet.getRow();
            accountHistory.getOperationList().put();
        }

        return accountHistory;
    }

}
