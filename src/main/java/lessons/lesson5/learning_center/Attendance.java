package lessons.lesson5.learning_center;

public class Attendance {
    public void markAttendance(Student student) {
        student.addAttendance();
        System.out.println("Посещаемость отмечена: " + student.getName());
    }
}