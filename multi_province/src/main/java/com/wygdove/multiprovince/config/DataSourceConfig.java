package com.wygdove.multiprovince.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import java.util.Arrays;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.DefaultBeanNameGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.util.StringUtils;

/**
 * @Title: DataSourceConfig
 * @Description:
 */
@Configuration
public class DataSourceConfig {
    private static Logger log=LoggerFactory.getLogger(DataSourceConfig.class);


    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(ProvinceConfigAware provinceConfigAware){
        String province=provinceConfigAware.getProvince();
        log.debug("DataSourceConfig.mapperScannerConfigurer province: {}",province);

        MapperScannerConfigurer scannerConfigurer=new MapperScannerConfigurer();
        final String BASE_PACKAGE_PREFIX="com.wygdove.multiprovince.dao.mapper.";
        String basePackages=BASE_PACKAGE_PREFIX+"common";
        if(StringUtils.hasText(province)) {
            basePackages+=","+BASE_PACKAGE_PREFIX+province;
        }
        scannerConfigurer.setBasePackage(basePackages);

        DefaultBeanNameGenerator defaultBeanNameGenerator=new DefaultBeanNameGenerator();
        scannerConfigurer.setNameGenerator((definition,registry)->{
            String result;
            String beanClassName=definition.getBeanClassName();
            if(StringUtils.hasText(beanClassName)&&beanClassName.startsWith(BASE_PACKAGE_PREFIX)) {
                result=beanClassName.substring(BASE_PACKAGE_PREFIX.length()).replaceAll("\\.","");
            }else {
                result=defaultBeanNameGenerator.generateBeanName(definition,registry);
            }
            return result;
        });

        scannerConfigurer.setSqlSessionTemplateBeanName("sqlSessionTemplate");
        return scannerConfigurer;
    }

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource,ProvinceConfigAware provinceConfigAware) throws Exception {
        MybatisSqlSessionFactoryBean bean=new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);

        Resource[] commonResouce=new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/common/*.xml");
        String province=provinceConfigAware.getProvince();
        Resource[] provinceResouce;
        if(StringUtils.hasText(province)) {
            provinceResouce=new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/"+province+"/*.xml");
        }else {
            provinceResouce=new Resource[0];
        }
        Resource[] mapperLocations=Arrays.copyOf(commonResouce,commonResouce.length+provinceResouce.length);
        System.arraycopy(provinceResouce,0,mapperLocations,commonResouce.length,provinceResouce.length);
        bean.setMapperLocations(mapperLocations);
        return bean.getObject();
    }

    @Bean(name="transactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name="sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}