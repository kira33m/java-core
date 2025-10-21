package lessons.lesson5.learning_center;

public class Student extends Person {
    private double totalGrade;
    private int attendanceCount;

    public Student(String id, String name) {
        super(id, name);
        this.totalGrade = 0;
        this.attendanceCount = 0;
    }

    public void addAttendance() { attendanceCount++; }
    public void addGrade(double grade) { totalGrade = grade; }

    @Override
    public void showInfo() {
        System.out.println(name + " (ID: " + id + ") " +
            "= Баллы: " + totalGrade +
            ", Посещений: " + attendanceCount);

    }
}