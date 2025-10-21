package lessons.lesson2;

import java.util.Random;
import java.util.Scanner;

public class Practice2 {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            System.out.println("\n=== МЕНЮ ЗАДАНИЙ ===");
            System.out.println("1.Обмен значений");
            System.out.println("2.Таблица умножения");
            System.out.println("3.Конвертер валют");
            System.out.println("4.Чётное или нечётное");
            System.out.println("5.Максимум из трёх");
            System.out.println("6.Калькулятор");
            System.out.println("7.Среднее арифметическое");
            System.out.println("8.Поиск элемента в массиве");
            System.out.println("9.Мини-игра 'Угадай число'");
            System.out.println("0.Выход");
            System.out.print("Выберите задачу: ");

            int choice=sc.nextInt();
            switch(choice){
                case 1 -> swapNumbers();
                case 2 -> multiplicationTable();
                case 3 -> currencyConverter();
                case 4 -> evenOrOdd();
                case 5 -> maxOfThree();
                case 6 -> calculator();
                case 7 -> averageArray();
                case 8 -> searchElement();
                case 9 -> guessNumberGame();
                case 0 -> {
                    System.out.println("Программа завершена.");
                    return;
                }
                default -> System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }

    static void swapNumbers(){
        System.out.print("Введите первое число: ");
        int a= sc.nextInt();
        System.out.print("Введите второе число: ");
        int b=sc.nextInt();
        System.out.println("До обмена: a = " + a + ", b = " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("После обмена: а = " + a + ", b = " + b);
    }

    static void multiplicationTable(){
        System.out.print("Введите число для таблицы умножения: ");
        int n = sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + "x" + i + " = " + (n * i));
        }
    }

    static void currencyConverter(){
        int exchange = 12500;
        System.out.print("Введите сумму в долларах: ");
        double dollars = sc.nextDouble();
        System.out.println("Сумма в сумах: " + (dollars  * exchange));
    }

    static void evenOrOdd() {
        System.out.print("Введите число: ");
        int n = sc.nextInt();
        if (n % 2 == 0) {
            System.out.println("Число четное");
        } else {
            System.out.println("Число нечетное");
        }
    }

    static void maxOfThree() {
        System.out.print("Введите три числа: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int max = Math.max(a, Math.max(b, c));
        System.out.println("Максимум: " + max);
    }

    static void calculator() {
        System.out.print("Введите первое число: ");
        double a = sc.nextDouble();
        System.out.print("Введите операцию (+, -, *, /): ");
        char op = sc.next().charAt(0);
        System.out.print("Введите второе число: ");
        double b = sc.nextDouble();

        switch (op) {
            case '+' -> System.out.println("Результат: " + (a + b));
            case '-' -> System.out.println("Результат: " + (a - b));
            case '*' -> System.out.println("Результат: " + (a * b));
            case '/' -> {
                if (b != 0) System.out.println("Результат: " + (a / b));
                else System.out.println("Ошибка: деление на ноль!");
            }
            default -> System.out.println("Неизвестная операция!");
        }
    }

    static void averageArray() {
        System.out.print("Введите количество чисел: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Введите число " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        double avg = (double) sum / n;
        System.out.println("Среднее значение: " + avg);
    }

    static void searchElement() {
        System.out.print("Введите размер массива: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Введите число " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        System.out.print("Введите число для поиска: ");
        int x = sc.nextInt();
        boolean found = false;
        for (int value : arr) {
            if (value == x) {
                found = true;
                break;
            }
        }
        if (found) System.out.println("Число найдено в массиве!");
        else System.out.println("Число не найдено.");
    }

    static void guessNumberGame() {
        Random rand = new Random();
        int secret = rand.nextInt(100) + 1; // число от 1 до 100
        int attempts = 7;
        System.out.println("Я загадал число от 1 до 100. У вас " + attempts + " попыток.");

        for (int i = 1; i <= attempts; i++) {
            System.out.print("Попытка " + i + ": ");
            int guess = sc.nextInt();
            if (guess == secret) {
                System.out.println("Поздравляю! Вы угадали число!");
                return;
            } else if (guess < secret) {
                System.out.println("Загаданное число больше.");
            } else {
                System.out.println("Загаданное число меньше.");
            }
        }
        System.out.println("Вы проиграли. Загаданное число было: " + secret);
    }
}
