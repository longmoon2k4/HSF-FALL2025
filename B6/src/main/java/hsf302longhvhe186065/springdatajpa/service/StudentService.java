package hsf302longhvhe186065.springdatajpa.service;

import hsf302longhvhe186065.springdatajpa.pojo.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findAll();

    void save(Student student);

    void delete(Student student);

    Optional<Student> findById(int studentID);

    Student update(int id, Student updatedStudent);
}
