package hfs302.he186065.longhv.main;

import hfs302.he186065.longhv.pojo.Student;
import hfs302.he186065.longhv.pojo.Book;
import hfs302.he186065.longhv.service.StudentService;
import hfs302.he186065.longhv.service.StudentServiceImpl;

public class Main {
    public static void main(String[] args) {
        String fileName = "JPAS";
        StudentService studentService = new StudentServiceImpl(fileName);
        Student student = new Student("lamn@gmail.com", "1234q", "Lam", "Nguyen", 9);
        Book book = new Book("Java Persistence with Spring", "Catalin Tudose", "9781617298016");
        book.setStudent(student);
        student.getBooks().add(book);
        studentService.save(student);
    }
}
