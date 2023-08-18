package Exercice002.Model;

import java.util.HashMap;

public class CompteBancaire {

    private int accountId;
    //private HashMap<Integer, Client> clientList;
    private double solde;

    private int clientId;
    private HashMap<Integer, Operation> operationList;

    public CompteBancaire(int accountId, HashMap<Integer, Operation> operationList, int clientId) {
        this.accountId = accountId;
        this.operationList = operationList;
        this.clientId = clientId;
    }

    public  CompteBancaire(int accountId, double solde, int clientId){
        this.accountId = accountId;
        this.solde = solde;
        this.clientId = clientId;
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

    public int getAccountId(){ return accountId;}

    public void setAccountId(int accountId){this.accountId = accountId;}

    public int getClientId(){ return  clientId ;}

    public void setClientId(){this.clientId = clientId;}
}
