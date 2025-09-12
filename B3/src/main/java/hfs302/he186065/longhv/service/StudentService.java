package hfs302.he186065.longhv.service;

import hfs302.he186065.longhv.pojo.Student;
import java.util.List;

public interface StudentService {
    List<Student> findAll();
    void save(Student student);
    void delete(int studentID);
    Student findById(int studentID);
    void update(Student student);
}

