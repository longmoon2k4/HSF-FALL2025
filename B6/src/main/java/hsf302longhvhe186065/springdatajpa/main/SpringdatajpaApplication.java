package hsf302longhvhe186065.springdatajpa.main;

import hsf302longhvhe186065.springdatajpa.pojo.Book;
import hsf302longhvhe186065.springdatajpa.pojo.Student;
import hsf302longhvhe186065.springdatajpa.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"hsf302longhvhe186065.springdatajpa.main","hsf302longhvhe186065.springdatajpa.service"})
@EnableJpaRepositories(basePackages = "hsf302longhvhe186065.springdatajpa.repository")
@EntityScan(basePackages = "hsf302longhvhe186065.springdatajpa.pojo")
public class SpringdatajpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdatajpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(StudentService service) {
        return (String[] args) -> {
            // Only create sample data if no students exist yet
            if (service.findAll().isEmpty()) {
                Student student = new Student( "gof@gmail.com", "1234@", "Mr", "Anh", 9 );
                Book book = new Book( "Java Persistence with Spring", "Catalin Tudose", "9781617299186" );
                student.getBooks().add(book);
                service.save(student);
                System.out.println("Sample data created: 1 Student with 1 Book");
            } else {
                System.out.println("Sample data already exists, skipping creation");
            }
        };
    }

}
