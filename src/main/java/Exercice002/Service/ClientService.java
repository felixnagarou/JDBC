package Exercice002.Service;

import Exercice002.DAO.ClientDAO;
import Exercice002.DAO.CompteDAO;
import Exercice002.DAO.OperationDAO;
import Exercice002.DataBaseManager;
import Exercice002.Model.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ClientService {
    private ClientDAO clientDAO;
    private Connection connection;
    public ClientService(){
        try {
            connection = new DataBaseManager().getConnection();
            clientDAO = new ClientDAO(connection);
        }catch (SQLException e){
            throw new RuntimeException();
        }

    }

    public boolean createClient(String firstName, String lastName) {
        Client client = new Client(lastName, firstName);
        try {
            if(clientDAO.save(client)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean updateClient(Client client) {
        try {
            if(clientDAO.update(client)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public Client getClient(int id) {
        try {
            return clientDAO.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteClient(int id) {
        Client client = null;
        try {
            client = clientDAO.get(id);
            if(client != null) {
                return clientDAO.delete(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<Client> getAllClients() {
        try {
            return clientDAO.get();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
