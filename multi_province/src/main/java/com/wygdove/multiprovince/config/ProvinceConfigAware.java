package com.wygdove.multiprovince.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @Title: ProvinceConfigAware
 * @Description:
 */
@Configuration
@PropertySource("classpath:application.properties")
public class ProvinceConfigAware implements EnvironmentAware {
    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment=environment;
    }

    public String getProvince() {
        return environment.getProperty("province");
    }


}
