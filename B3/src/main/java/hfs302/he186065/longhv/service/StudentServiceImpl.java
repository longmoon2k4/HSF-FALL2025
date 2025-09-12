package hfs302.he186065.longhv.service;

import hfs302.he186065.longhv.pojo.Student;
import hfs302.he186065.longhv.repository.StudentRepository;
import hfs302.he186065.longhv.repository.StudentRepositoryImpl;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentRepository iStudentRepo = null;

    public StudentServiceImpl(String fileName) {
        iStudentRepo = new StudentRepositoryImpl(fileName);
    }

    @Override
    public void save(Student student) {
        iStudentRepo.save(student);
    }

    @Override
    public List<Student> findAll() {
        return iStudentRepo.findAll();
    }

    @Override
    public void delete(int studentID) {
        iStudentRepo.delete(studentID);
    }

    @Override
    public Student findById(int studentID) {
        return iStudentRepo.findById(studentID);
    }

    @Override
    public void update(Student student) {
        iStudentRepo.update(student);
    }
}

