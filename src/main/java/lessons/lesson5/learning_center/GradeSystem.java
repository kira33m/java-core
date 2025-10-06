package lessons.lesson5.learning_center;

public class GradeSystem {
    public void assignGrade(Student student, double grade) {
        student.addGrade(grade);
        System.out.println("Оценка " + grade + " выставлена студенту " + student.getName());
    }
}