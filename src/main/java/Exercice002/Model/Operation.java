package Exercice002.Model;

public class Operation {
    private int number;
    private double amount;
    private enum status{
        DEPOSIT,
        WITHDRAW
    }

    public Operation(int number, double amount) {
        this.number = number;
        this.amount = amount;
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
