package com.wygdove.dvconfig.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @Title: ZooKeeperConfigAware
 * @Description:
 */
@Configuration
public class ZooKeeperConfigAware  implements EnvironmentAware {
    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment=environment;
    }

    public String getZooKeeperAddress() {
        return environment.getProperty("zookeeper.address");
    }

    public int getZooKeeperTimeout() {
        return environment.getProperty("zookeeper.timeout",Integer.class);
    }

}