package hfs302.he186065.longhv.services;

import org.springframework.stereotype.Service;
import hfs302.he186065.longhv.pojo.Student;

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public void save(Student student) {
        System.out.println("Save Student...");
    }
}

