package hfs302.he186065.longhv.repository;
import hfs302.he186065.longhv.pojo.Student;
import java.util.List;


public interface StudentRepository {
    List<Student> findAll();
    void save(Student student);
    void delete(int studentID);
    Student findById(int studentID);
    void update(Student student);
}
