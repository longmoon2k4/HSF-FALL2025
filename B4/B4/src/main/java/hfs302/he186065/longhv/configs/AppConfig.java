package hfs302.he186065.longhv.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import hfs302.he186065.longhv.services.StudentService;
import hfs302.he186065.longhv.services.StudentServiceImpl;
import hfs302.he186065.longhv.aspects.LoggingAspect;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    public StudentService myService() {
        return new StudentServiceImpl();
    }

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }
}
