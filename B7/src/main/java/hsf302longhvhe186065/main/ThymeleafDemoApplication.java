package hsf302longhvhe186065.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import hsf302longhvhe186065.repository.UserRepository;
import hsf302longhvhe186065.pojo.User;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication(scanBasePackages = "hsf302longhvhe186065")
@EnableJpaRepositories(basePackages = "hsf302longhvhe186065.repository")
@EntityScan(basePackages = "hsf302longhvhe186065.pojo")
public class ThymeleafDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThymeleafDemoApplication.class, args);
    }

    @Bean
    public org.springframework.boot.CommandLineRunner dataSeeder(UserRepository userRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                User u1 = new User("Nguyen", "Lima", "nguyenvvna@example.com", "123456",
                        "male", Arrays.asList("reading", "music", "sport"),
                        "Ha Noi Capital", new Date());
                User u2 = new User("Tran", "Minh", "minhtran@example.com", "123456",
                        "female", Arrays.asList("travel", "cooking"),
                        "Ho Chi Minh City", new Date());
                userRepository.saveAll(Arrays.asList(u1, u2));
            }
        };
    }
}
