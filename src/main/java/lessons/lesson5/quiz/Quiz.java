package lessons.lesson5.quiz;

import java.util.*;

public class Quiz {
    private final String title;
    private final List<Question> questions = new ArrayList<>();
    private final List<Team> teams = new ArrayList<>();

    public Quiz(String title) {
        this.title = title;
    }

    public void addQuestion(Question q) { questions.add(q); }
    public void addTeam(Team t) { teams.add(t); }

    public void run(Scanner scanner) {
        if (questions.isEmpty()) {
            System.out.println("Нет вопросов!");
            return;
        }
        if (teams.isEmpty()) {
            System.out.println("Нет команд!");
            return;
        }

        System.out.println("\nЗапуск квиза: " + title);
        for (Question q : questions) {
            for (Team team : teams) {
                System.out.println("\nКоманда: " + team.getName());
                boolean correct = q.askAndCheckAnswer(scanner);
                if (correct) {
                    team.addScore(1);
                    System.out.println("Верно! +1 балл.");
                } else {
                    System.out.println("Неверно.");
                }
            }
        }
        System.out.println("\nКвиз завершён!");
    }

    public void showResults() {
        System.out.println("\n=== Результаты квиза: " + title + " ===");
        teams.sort((a, b) -> Integer.compare(b.getScore(), a.getScore()));
        for (int i = 0; i < teams.size(); i++) {
            Team t = teams.get(i);
            System.out.printf("%d) %s — %d баллов%n", i + 1, t.getName(), t.getScore());
        }
    }
}
