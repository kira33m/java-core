package lessons.lesson3;

import java.util.ArrayList;
import java.util.List;

public class BankSystem {

    private String accountNumber;
    private String fio;
    private double balance;

    private static List<BankSystem> accounts = new ArrayList<>();

    public BankSystem(String accountNumber, String fio, double balance) {
        this.accountNumber = accountNumber;
        this.fio = fio;
        this.balance = balance;
    }

    public void getAccountInfo() {
        System.out.println("Счёт: " + accountNumber +
            ". Владелец: " + fio +
            ", Баланс: " + balance);
    }

    public static void addAccount(BankSystem account) {
        accounts.add(account);
        System.out.println("Счёт добавлен: " + account.fio);
    }

    public static void deleteAccount(String accountNumber) {
        accounts.removeIf(acc -> acc.accountNumber.equals(accountNumber));
        System.out.println("Счёт удалён: " + accountNumber);
    }

    public void replenishAccount(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Счёт пополнен: " + amount);
        }
    }
    public static void transferMoneyBetweenAccounts(String fromAcc, String toAcc, double amount) {
        BankSystem from = null;
        BankSystem to = null;
        for (BankSystem acc : accounts) {
            if (acc.accountNumber.equals(fromAcc)) from = acc;
            if (acc.accountNumber.equals(toAcc)) to = acc;
        }
        if (from != null && to != null && from.balance >= amount ) {
            from.balance -= amount;
            to.balance += amount;
            System.out.println("Переведо " + amount + " со счёта " + fromAcc + " на счёт " +  toAcc);
        } else {
            System.out.println("Ошибка при переводе средств.");
        }
    }
}

