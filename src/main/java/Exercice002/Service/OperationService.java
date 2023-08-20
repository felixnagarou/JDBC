package Exercice002.Service;

import Exercice002.DAO.ClientDAO;
import Exercice002.DAO.OperationDAO;
import Exercice002.DataBaseManager;
import Exercice002.Model.Client;
import Exercice002.Model.Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class OperationService {
    private OperationDAO operationDAO;
    private Connection connection;

    public OperationService(){
        try {
            connection = new DataBaseManager().getConnection();
            operationDAO = new OperationDAO(connection);
        }catch (SQLException e){
            throw new RuntimeException();
        }

    }

    public boolean createOperation(int number, double amount, boolean status, int accountId) {
        Operation operation = new Operation(number, amount, status, accountId);
        try {
            if(operationDAO.save(operation)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean updateOperation(Operation operation) {
        try {
            if(operationDAO.update(operation)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public Operation getOperation(int id) {
        try {
            return operationDAO.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteOperation(int id) {
        Operation operation = null;
        try {
            operation = operationDAO.get(id);
            if(operation != null) {
                return operationDAO.delete(operation);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<Operation> getAllOperations() {
        try {
            return operationDAO.get();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
