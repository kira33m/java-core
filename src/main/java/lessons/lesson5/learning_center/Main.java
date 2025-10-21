package lessons.lesson5.learning_center;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Teacher teacher = new Teacher("T001", "Евгений");
        Course course = new Course("C001", "Java Programming", teacher);

        boolean running = true;

        while (running) {
            System.out.println("\n=== Учебный центр ===");
            System.out.println("1. Добавить студента");
            System.out.println("2. Отметить посещаемость");
            System.out.println("3. Поставить оценку");
            System.out.println("4. Показать информацию о курсе");
            System.out.println("5. Выйти");
            System.out.print("Выберите пункт: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите ID студента: ");
                    String id = sc.nextLine();
                    System.out.print("Введите имя студента: ");
                    String name = sc.nextLine();
                    course.addStudent(new Student(id, name));
                    break;
                case 2:
                    System.out.print("Введите ID студента для отметки: ");
                    id = sc.nextLine();
                    course.markAttendance(id);
                    break;
                case 3:
                    System.out.print("Введите ID студента: ");
                    id = sc.nextLine();
                    System.out.print("Введите балл: ");
                    double grade = sc.nextDouble();
                    course.addGrade(id, grade);
                    break;
                case 4:
                    course.showCourseInfo();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
        sc.close();
    }
}
