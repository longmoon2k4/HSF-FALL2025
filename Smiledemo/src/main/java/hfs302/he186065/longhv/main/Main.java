package hfs302.he186065.longhv.main;

import hfs302.he186065.longhv.pojo.Student;
import hfs302.he186065.longhv.service.StudentService;
import hfs302.he186065.longhv.service.StudentServiceImpl;

public class Main {
    public static void main(String[] args) {
        String fileName = "JPAS";
        StudentService studentService = new StudentServiceImpl(fileName);
        Student student = new Student("Lam", "Nguyen", 0);
        studentService.save(student);
    }
}