package oop.bankaccount;

public class BankAccount {
    private double amount;
    private double interestRate;
    private String name;

    BankAccount(String name, double amount, double interestRate){
        this.name = name;
        this.amount = amount;
        this.interestRate = interestRate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void applyInterest(){
        this.amount = this.amount + ((this.interestRate/100) * this.amount);
    }
}
