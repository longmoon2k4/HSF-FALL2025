package hfs302.he186065.longhv.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    public LoggingAspect() {}

    @Before("execution(* hfs302.he186065.longhv.services.StudentServiceImpl.save(..))")
    public void logBefore() {
        logger.debug("LoggingAspect: Before method Save Student()");
        System.out.println("LoggingAspect: Before method Save Student()");
    }

    @After("execution(* hfs302.he186065.longhv.services.StudentServiceImpl.save(..))")
    public void logAfter() {
        logger.debug("LoggingAspect: After method Save Student()");
        System.out.println("LoggingAspect: After method Save Student()");
    }
}

