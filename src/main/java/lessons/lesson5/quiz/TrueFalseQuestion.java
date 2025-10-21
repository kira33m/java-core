package lessons.lesson5.quiz;

import java.util.Scanner;

public class TrueFalseQuestion extends Question {
    private final boolean correctAnswer;

    public TrueFalseQuestion(String text, boolean correctAnswer) {
        super(text);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean askAndCheckAnswer(Scanner scanner) {
        System.out.println(getText() + " (true/false)");
        System.out.print("Ваш ответ: ");
        boolean userAnswer = Boolean.parseBoolean(scanner.nextLine());
        return userAnswer == correctAnswer;
    }
}
