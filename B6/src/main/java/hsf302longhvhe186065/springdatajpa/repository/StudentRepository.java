package hsf302longhvhe186065.springdatajpa.repository;

import hsf302longhvhe186065.springdatajpa.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
