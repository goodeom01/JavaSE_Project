package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student();

        try {
            student.setName("김민수");
            student.setMajor("컴퓨터공학");
            student.setGrade(3);
            System.out.println(student);

            student.setGrade(5);
        } catch (InvalidGradeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(student);
    }
}
