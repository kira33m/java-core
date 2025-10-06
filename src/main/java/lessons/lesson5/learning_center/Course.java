package lessons.lesson5.learning_center;

import java.util.ArrayList;

public class Course {
    private final String courseID;
    private final String title;
    private final Teacher teacher;
    private final ArrayList<Student> students;
    private final Attendance attendance;
    private final GradeSystem gradeSystem;

    public Course(String courseID, String title, Teacher teacher) {
        this.courseID = courseID;
        this.title = title;
        this.teacher = teacher;
        this.students = new ArrayList<>();
        this.attendance = new Attendance();
        this.gradeSystem = new GradeSystem();
    }
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Студент " + student.getName() + " добавлен на курс.");
    }
    public void markAttendance(String studentID) {
        Student student = findStudent(studentID);
        if (student != null) {
            attendance.markAttendance(student);
        } else {
            System.out.println("Студент не найден");
        }
    }
    public void addGrade(String studentId, double grade) {
        Student student = findStudent(studentId);
        if (student != null) {
            gradeSystem.assignGrade(student, grade);
        } else {
            System.out.println("Студент не найден");
        }
    }
    public void showCourseInfo() {
        System.out.println("\n=== Информация о курсе ===");
        System.out.println("Курс: " + title + " (ID: " + courseID + ")");
        teacher.showInfo();
        System.out.println("Студенты:");
        for (Student s : students) {
            s.showInfo();
        }
    }
    private Student findStudent(String ID) {
        for (Student s : students)
            if (s.getId().equals(ID))
                return s;
        return null;
    }
}