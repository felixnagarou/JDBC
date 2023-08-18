package Exercice002.DAO;

import Exercice002.Model.CompteBancaire;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class compteDAO extends BaseDAO<CompteBancaire>{

    protected compteDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(CompteBancaire element) throws SQLException {
        query = "INSERT into account (solde, clientId) VALUES ( ?, ?)";
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
    public boolean update(CompteBancaire element) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(CompteBancaire element) throws SQLException {
        return false;
    }

    @Override
    public CompteBancaire get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<CompteBancaire> get() throws SQLException {
        return null;
    }
}
