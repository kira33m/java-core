package lessons.lesson5.quiz;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static Quiz quiz;

    public static void main(String[] args) {
        System.out.println("=== Добро пожаловать в консольный Онлайн-Квиз ===");

        boolean exit = false;
        while (!exit) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1": createQuiz(); break;
                case "2": addQuestion(); break;
                case "3": addTeam(); break;
                case "4": startQuiz(); break;
                case "5": showResults(); break;
                case "0": exit = true; break;
                default: System.out.println("Неверный выбор.");
            }
        }
        System.out.println("Выход. Спасибо!");
    }

    private static void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Создать квиз");
        System.out.println("2. Добавить вопрос");
        System.out.println("3. Добавить команду");
        System.out.println("4. Запустить квиз");
        System.out.println("5. Показать результаты");
        System.out.println("0. Выйти");
        System.out.print("Выберите: ");
    }

    private static void createQuiz() {
        System.out.print("Название квиза: ");
        String title = scanner.nextLine();
        quiz = new Quiz(title);
        System.out.println("Создан квиз: " + title);
    }

    private static void addQuestion() {
        if (ensureQuiz()) return;
        System.out.println("\n1. Множественный выбор\n2. Правда/ложь");
        System.out.print("Тип вопроса: ");
        String type = scanner.nextLine();

        switch (type) {
            case "1":
                System.out.print("Текст вопроса: ");
                String text = scanner.nextLine();
                List<String> options = new ArrayList<>();
                for (int i = 1; i <= 4; i++) {
                    System.out.print("Вариант " + i + ": ");
                    options.add(scanner.nextLine());
                }
                System.out.print("Номер правильного (1–4): ");
                int correct = Integer.parseInt(scanner.nextLine()) - 1;
                quiz.addQuestion(new MultipleChoiceQuestion(text, options, correct));
                break;

            case "2":
                System.out.print("Текст вопроса: ");
                String t = scanner.nextLine();
                System.out.print("Правильный ответ (true/false): ");
                boolean answer = Boolean.parseBoolean(scanner.nextLine());
                quiz.addQuestion(new TrueFalseQuestion(t, answer));
                break;

            default:
                System.out.println("Неверный выбор.");
        }
    }

    private static void addTeam() {
        if (ensureQuiz()) return;
        System.out.print("Название команды: ");
        String name = scanner.nextLine();
        quiz.addTeam(new Team(name));
        System.out.println("Команда добавлена.");
    }

    private static void startQuiz() {
        if (ensureQuiz()) return;
        quiz.run(scanner);
    }

    private static void showResults() {
        if (ensureQuiz()) return;
        quiz.showResults();
    }

    private static boolean ensureQuiz() {
        if (quiz == null) {
            System.out.println("Сначала создайте квиз (1).");
            return true;
        }
        return false;
    }
}

