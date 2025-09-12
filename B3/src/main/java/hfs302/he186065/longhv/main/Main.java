package hfs302.he186065.longhv.main;

import hfs302.he186065.longhv.pojo.Student;
import hfs302.he186065.longhv.pojo.Book;
import hfs302.he186065.longhv.service.StudentServiceImpl;
import hfs302.he186065.longhv.service.StudentService;

public class Main {
    public static void main(String[] args) {
        String fileName = "JPAS";
        StudentService studentService = new StudentServiceImpl(fileName);
        Student student = new Student("lamng@gmail.com", "1234q", "Lam", "Nguyen", 0);
        Book book = new Book("Java Persistence with Spring", "Catalin Tudose", "9786152079186");
        student.getBooks().add(book);
        studentService.save(student);
    }
}
