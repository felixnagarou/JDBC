package Exercice002.DAO;

import Exercice002.Model.CompteBancaire;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class compteDAO extends BaseDAO<CompteBancaire>{

    protected compteDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(CompteBancaire element) throws SQLException {
        return false;
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
