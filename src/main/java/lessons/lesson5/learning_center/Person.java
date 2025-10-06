package lessons.lesson5.learning_center;

public abstract class Person {
    protected String id;
    protected String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void showInfo();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
