package com.wygdove.multiprovince.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: ProvinceConfig
 * @Description:
 */
@Configuration
public class ProvinceConfig {

    private String province;

    @Value("${province}")
    public void setProvince(String province) {
        this.province=province;
    }

    public String getProvince() {
        return province;
    }
}
