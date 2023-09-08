package ru.specialist.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Properties;


@Configuration
@PropertySource(value = "/WEB-INF/config/jdbc.properties") //<context:property-placeholder location=".." />
@ComponentScan(basePackages = {"ru.specialist.controllers", "ru.specialist.model"})
@EnableWebMvc
//@EnableScheduling //task:annotation-driven
public class ApplicationConfig {

    /**
     * @PropertySource annotation does not automatically
     * register a PropertySourcesPlaceholderConfigurer with Spring.
     * So we need to initialize this bean.
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Value("${jdbc.driverClassName}")
    private String driverClass;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUserName;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    /**
     * <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
     */
    @Bean(name = "dataSource")
    public DriverManagerDataSource getDriverManagerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(jdbcUserName);
        dataSource.setPassword(jdbcPassword);
        return dataSource;
    }



    /**
     *  <bean id="restTemplate" class="org.springframework.web.client.RestTemplate"/>
     */
    @Bean(name = "restTemplate")
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     * <bean id="entityManagerFactory"
     class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean" >
     */
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPackagesToScan(new String[] {"ru.specialist.DAO"});
        em.setDataSource(getDriverManagerDataSource());

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        ((HibernateJpaVendorAdapter)vendorAdapter).setGenerateDdl(true);
        ((HibernateJpaVendorAdapter)vendorAdapter).setShowSql(true);
        em.setJpaVendorAdapter(vendorAdapter);

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
        jpaProperties.put("hibernate.max_fetch_depth",3);
        jpaProperties.put("hibernate.fetch_size",50);
        jpaProperties.put("hibernate.batch_size",10);
        jpaProperties.put("hibernate.show_sql",true);

        em.setJpaProperties(jpaProperties);
        return em;
    }

    @Bean(name = "jpaTransactionManager")
    public JpaTransactionManager getJpaTransactionManager() {
        JpaTransactionManager jpa = new JpaTransactionManager();
        jpa.setEntityManagerFactory(getLocalContainerEntityManagerFactoryBean().getNativeEntityManagerFactory());
        return jpa;
    }
    
    /**
     * <bean id="messageSource" class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
     */
    @Bean(name = "myMessageSource")
    public ReloadableResourceBundleMessageSource myMessageSource() {
        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
        resource.setBasename("/WEB-INF/i18n/messages");
        resource.setCacheSeconds(1);
        resource.setDefaultEncoding("UTF-8");
        resource.setFallbackToSystemLocale(false);
        return resource;
    }

}
