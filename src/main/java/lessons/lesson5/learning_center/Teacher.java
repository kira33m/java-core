package lessons.lesson5.learning_center;

public class Teacher extends Person {
    public Teacher(String id,  String name) {
        super(id, name);
    }
    @Override
    public void showInfo() {
        System.out.println("Преподователь: " + name + " (ID: " + id + ")");
    }
}