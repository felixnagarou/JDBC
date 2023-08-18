package Exercice002.Model;

public class Operation {
    private int number;
    private double amount;
    private boolean status;

    public Operation(int number, double amount, boolean status, int accountId) {
        this.number = number;
        this.amount = amount;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
