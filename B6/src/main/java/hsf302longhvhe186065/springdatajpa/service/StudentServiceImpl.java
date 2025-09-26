package hsf302longhvhe186065.springdatajpa.service;

import hsf302longhvhe186065.springdatajpa.pojo.Student;
import hsf302longhvhe186065.springdatajpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository iStudentRepo;

    @Override
    public void save(Student student) { iStudentRepo.save(student); }

    @Override
    public List<Student> findAll() { return iStudentRepo.findAll(); }

    @Override
    public void delete(Student student) { iStudentRepo.delete(student); }

    @Override
    public Optional<Student> findById(int studentID) { return iStudentRepo.findById(studentID); }

    @Override
    public Student update(int id, Student updatedStudent) {
        Optional<Student> existingStudentOpt = iStudentRepo.findById(id);

        if (existingStudentOpt.isPresent()) {
            Student existingStudent = existingStudentOpt.get();
            return iStudentRepo.save(existingStudent);
        }

        return null;
    }
}
