package lessons.lesson2;

import java.util.Scanner; // библиотека для того чтобы считывать данные с консоли

public class Practice1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice;

        do {  // основная менюшка с заданиями
            System.out.println("\n=== МЕНЮ ЗАДАНИЙ ===");
            System.out.println("1.Вывести числа от 1 до 100");
            System.out.println("2.Сумма чисел от 1 до N");
            System.out.println("3.Произведение чисел от 1 до N");
            System.out.println("4.Сумма четных чисел от 1 до N");
            System.out.println("5.Сумма цифр числа");
            System.out.println("6.Разворот числа");
            System.out.println("7.Найти первое число, которое делится на 7 и больше 1000");
            System.out.println("8.Вывести все простые числа до N");
            System.out.println("0.Выход");
            System.out.print("Выберите задание: ");
            choice=sc.nextInt();

            switch (choice) {
                case 1:
                    printNumbers1to100();
                    break;
                case 2:
                    System.out.print("Введите N: ");
                    int num1=sc.nextInt();
                    System.out.println("Сумма = " + sum1toN(num1));
                    break;
                case 3:
                    System.out.print("Введите N: ");
                    int num2 = sc.nextInt();
                    System.out.println("Произведение = " + product1toN(num2));
                    break;
                case 4:
                    System.out.print("Введите N: ");
                    int num3 = sc.nextInt();
                    System.out.println("Сумма четных = " + sumEven1toN(num3));
                    break;
                case 5:
                    System.out.print("Введите число: ");
                    int num4 = sc.nextInt();
                    System.out.println("Сумма цифр = " + sumOfDigits(num4));
                    break;
                case 6:
                    System.out.print("Введите число: ");
                    int num5 = sc.nextInt();
                    System.out.println("Разворот = " + reverseNumber(num5));
                    break;
                case 7:
                    System.out.println("Первое число >1000, делящееся на 7: " + firstDivisibleBy7Over1000());
                    break;
                case 8:
                    System.out.print("Введите N: ");
                    int num6 = sc.nextInt();
                    System.out.println("Простые числа до " + num6 + ":");
                    printPrimesUpToN(num6);
                    break;
                case 0:
                    System.out.println("Выход...");
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        } while (choice != 0);

        sc.close();
    }

    public static void printNumbers1to100() {
        for (int i = 1; i <= 100; i++) {
            System.out.printf("%4d", i);
            if(i % 10 == 0) System.out.println();
        }
    }

    public static int sum1toN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        return sum;
    }

    public static long product1toN(int n) {
        long product = 1;
        for (int i = 1; i <= n; i++) product *= i;
        return product;
    }

    public static int sumEven1toN(int n) {
        int sum = 0;
        for (int i = 2; i <= n; i += 2) sum += i;
        return sum;
    }

    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static int reverseNumber(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed =  reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }

    public static int firstDivisibleBy7Over1000() {
        return ((1000 / 7) + 1) * 7;
    }

    public static void printPrimesUpToN(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
