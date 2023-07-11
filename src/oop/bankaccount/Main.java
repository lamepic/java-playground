package oop.bankaccount;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Juan De Hattatime", 1000, 3);

        account.applyInterest();
        System.out.println(account.getAmount());

        account.setInterestRate(2);
        account.applyInterest();
        System.out.println(account.getAmount());
    }
}
