package Exercice002.DAO;

import Exercice002.Model.Client;
import Exercice002.Model.Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class clientDAO extends BaseDAO<Client> {
    protected clientDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Client element) throws SQLException {
        query = "INSERT into client (first_name, last_name) VALUES ( ?, ?)";
        statement = _connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, element.getFirstName());
        statement.setString(2, element.getLastName());
        int nbRows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            element.setId(resultSet.getInt(1));
        }
        return nbRows == 1;
    }

    @Override
    public boolean update(Client element) throws SQLException {
        query = "UPDATE operation SET amount = ? WHERE id = ?";
        statement = _connection.prepareStatement(query);
        statement.setString(1, element.getFirstName());
        statement.setString(2, element.getLastName());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public boolean delete(Client element) throws SQLException {
        query = "DELETE FROM operation where id = ?";
        statement = _connection.prepareStatement(query);
        statement.setInt(1, element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public Client get(int id) throws SQLException {
        Client client = null;
        query = "SELECT FROM operation where id = ?";
        statement = _connection.prepareStatement(query);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            client = new Client(resultSet.getString("first_name"),
                    resultSet.getString("last_name"));
        }
        return client;
    }

    @Override
    public List<Client> get() throws SQLException {
        List<Client> result = new ArrayList<>();
        query = "SELECT * from operation";
        statement = _connection.prepareStatement(query);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Client client = new Client(resultSet.getString("first_name"), resultSet.getString("last_name"));
            result.add(client);
        }
        return result;
    }
}
