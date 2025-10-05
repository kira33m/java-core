package lessons.lesson3;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BankAccount {
    private final String fio;
    private final String accountNumber;
    private double balance;

    public BankAccount(String fio, String accountNumber, double balance) {
        this.fio = fio;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Счёт пополнен на " + amount + ". Новый баланс: " + balance);
        } else {
            System.out.println("Сумма пополнения должна быть положительной!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Со счёта снято " + amount + ". Новый баланс: " + balance);
        } else {
            System.out.println("Недостаточно средств или неверная сумма!");
        }
    }

    public void printAccountInfo() {
        System.out.println("ФИО: " + fio);
        System.out.println("Номер счёта: " + accountNumber);
        System.out.println("Баланс: " + balance);
    }
}
