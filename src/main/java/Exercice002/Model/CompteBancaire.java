package Exercice002.Model;

import java.util.HashMap;

public class CompteBancaire {
    private HashMap<Integer, Client> clientList;
    private double solde;
    private HashMap<Integer, Operation> operationList;

    public CompteBancaire(HashMap<Integer, Client> clientList, double solde, HashMap<Integer, Operation> operationList) {
        this.clientList = clientList;
        this.solde = solde;
        this.operationList = operationList;
    }

    public HashMap<Integer, Client> getClientList() {
        return clientList;
    }

    public void setClientList(HashMap<Integer, Client> clientList) {
        this.clientList = clientList;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public HashMap<Integer, Operation> getOperationList() {
        return operationList;
    }

    public void setOperationList(HashMap<Integer, Operation> operationList) {
        this.operationList = operationList;
    }
}
