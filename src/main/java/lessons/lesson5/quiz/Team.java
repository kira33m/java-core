package lessons.lesson5.quiz;

public class Team {
    private final String name;
    private int score;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        if (points > 0) score += points;
    }
}
