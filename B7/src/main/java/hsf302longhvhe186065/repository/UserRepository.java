package hsf302longhvhe186065.repository;

import hsf302longhvhe186065.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    void deleteByEmail(String email);
}