package lessons.lesson5.quiz;

import java.util.*;

public class MultipleChoiceQuestion extends Question {
    private final List<String> options;
    private final int correctIndex;

    public MultipleChoiceQuestion(String text, List<String> options, int correctIndex) {
        super(text);
        this.options = new ArrayList<>(options);
        this.correctIndex = correctIndex;
    }

    @Override
    public boolean askAndCheckAnswer(Scanner scanner) {
        System.out.println(getText());
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ") " + options.get(i));
        }
        System.out.print("Ваш ответ: ");
        int answer = Integer.parseInt(scanner.nextLine()) - 1;
        return answer == correctIndex;
    }
}
