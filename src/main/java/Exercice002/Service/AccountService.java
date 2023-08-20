package Exercice002.Service;

import Exercice002.DAO.ClientDAO;
import Exercice002.DAO.CompteDAO;
import Exercice002.DataBaseManager;
import Exercice002.Model.Client;
import Exercice002.Model.CompteBancaire;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AccountService {
    private CompteDAO compteDAO;
    private Connection connection;

    public AccountService(){
        try {
            connection = new DataBaseManager().getConnection();
            compteDAO= new CompteDAO(connection);
        }catch (SQLException e){
            throw new RuntimeException();
        }

    }

    public boolean createAccount(int accountId, Double solde, int clientId) {
        CompteBancaire account = new CompteBancaire(accountId, solde, clientId);
        try {
            if(compteDAO.save(account)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean updateAccount(CompteBancaire account) {
        try {
            if(compteDAO.update(account)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public CompteBancaire getAccount(int id) {
        try {
            return compteDAO.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteAccount(int id) {
        CompteBancaire account = null;
        try {
            account = compteDAO.get(id);
            if(account != null) {
                return compteDAO.delete(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<CompteBancaire> getAllAccounts() {
        try {
            return compteDAO.get();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CompteBancaire consultOperationHistory(int id) {
        try {
            return compteDAO.getHistory(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
