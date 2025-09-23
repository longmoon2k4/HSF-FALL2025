package hfs302.he186065.longhv.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Root application class placed at the top package so Spring Boot's component scan
 * automatically finds controllers and other components in subpackages (controller, pojo, etc.).
 */
@SpringBootApplication
public class SpringBootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }
}

