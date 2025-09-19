package hfs302.he186065.longhv.gui;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import hfs302.he186065.longhv.configs.AppConfig;
import hfs302.he186065.longhv.services.StudentService;
import hfs302.he186065.longhv.pojo.Student;

public class ManyToOne {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentService myService = context.getBean(StudentService.class);
        Student st = new Student("Lam", "Nguyen", 8);
        myService.save(st);
        context.close();
    }
}

