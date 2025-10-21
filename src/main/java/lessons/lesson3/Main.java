package lessons.lesson3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Меню ===");
            System.out.println("1. Person");
            System.out.println("2. Rectangle");
            System.out.println("3. Car");
            System.out.println("4. BankAccount");
            System.out.println("5. Book");
            System.out.println("6. OnlineStore");
            System.out.println("7. BankSystem");
            System.out.println("0. Выход");
            System.out.print("Выберите опцию: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    Person p  = new Person("Алмаз", 19);
                    p.introduce();
                }
                case 2 -> {
                    Rectangle r = new Rectangle(3, 15);
                    System.out.println("Периметр равен " + r.calculatePerimeter());
                    System.out.println("Площадь равна " + r.calculateSquare());
                }
                case 3 -> {
                    Car car1 = new Car("USA", "Chevrolet Impala", 1967);
                    Car car2 = new Car("Uzbekistan", "Chevrolet Cobalt", 2012);
                    car1.printCarInfo();
                    System.out.println("====");
                    car2.printCarInfo();
                }
                case 4 -> {
                    BankAccount acc = new BankAccount("Albert Albertovich", "0101001010", 1000);

                    acc.printAccountInfo();
                    acc.deposit(500);
                    acc.withdraw(200);
                    System.out.println("Текущий баланс: " + acc.getBalance());
                }
                case 5 -> {
                    Book b1 = new Book("123-456", "Война и мир", "Л. Толстой", 1869);
                    Book b2 = new Book("789-101", "Преступление и наказание", "Ф. Достоевский", 1866);

                    Book.addNewBook(b1);
                    Book.addNewBook(b2);

                    System.out.println("\nСписок всех книг:");
                    Book.getBooks();

                    System.out.println("\nБронирование книги:");
                    b1.reserveBook();

                    System.out.println("\nСписок после бронирования:");
                    Book.getBooks();
                }
                case 6 -> {
                    OnlineStore o1 = new OnlineStore("001", "Ноутбук", 1500, 5);
                    OnlineStore o2 = new OnlineStore("002", "Смартфон", 800, 10);

                    OnlineStore.addProduct(o1);
                    OnlineStore.addProduct(o2);

                    OnlineStore.getProducts();

                    o1.buyProduct(2);
                    o2.buyProduct(12);

                    OnlineStore.getProducts();
                }
                case 7 -> {
                    BankSystem acc1 = new BankSystem("111", "Bill Gates", 200);
                    BankSystem acc2 = new BankSystem("222", "Elon Musk", 500);

                    BankSystem.addAccount(acc1);
                    BankSystem.addAccount(acc2);

                    acc1.getAccountInfo();
                    acc2.getAccountInfo();

                    acc1.replenishAccount(300);
                    acc1.getAccountInfo();

                    BankSystem.transferMoneyBetweenAccounts("222", "111", 100);
                    acc1.getAccountInfo();
                    acc2.getAccountInfo();

                    BankSystem.deleteAccount("222");
                    acc2.getAccountInfo();
                }
                case 0 -> {
                    System.out.println("Выход");
                    return;
                }
                default -> System.out.println("Неверный выбор");
            }
        }
    }
}
