package com.wygdove.dvconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * @Title: Application
 * @Description: Application
 */
@SpringBootApplication(
        scanBasePackages={"com.wygdove.dvconfig"},
        exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class}
)
public class Application {
    private static final Logger log=LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
        log.error("==================== started ====================");
    }

}