package com.wygdove;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @Title: Application
 * @Description: Application
 */
@SpringBootApplication(scanBasePackages={"com.wygdove"})
public class Application {
    private static final Logger log=LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
        log.error("==================== started ====================");
    }

}
