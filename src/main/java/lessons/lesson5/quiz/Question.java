package lessons.lesson5.quiz;

import java.util.Scanner;

public abstract class Question {
    private final String text;

    public Question(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public abstract boolean askAndCheckAnswer(Scanner scanner);
}
