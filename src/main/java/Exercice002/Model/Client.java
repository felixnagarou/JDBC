package Exercice002.Model;

import java.util.HashMap;

public class Client {
    private String lastName;
    private String firstName;
    private int id;
    private HashMap<Integer, CompteBancaire> accountList;

    public Client(String lastName, String firstName, int id, HashMap<Integer, CompteBancaire> accountList) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
        this.accountList = accountList;
    }

    public Client(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Integer, CompteBancaire> getAccountList() {
        return accountList;
    }

    public void setAccountList(HashMap<Integer, CompteBancaire> accountList) {
        this.accountList = accountList;
    }
}
