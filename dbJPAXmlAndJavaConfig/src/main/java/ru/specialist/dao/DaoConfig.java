package ru.specialist.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.apache.commons.dbcp.BasicDataSource;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.springframework.orm.jpa.JpaTransactionManager;

import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;


@Configuration
@ComponentScan("ru.specialist.dao")
@EnableTransactionManagement
@PropertySource("jdbc.properties")
@EnableCaching
public class DaoConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource webDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		return ds;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean emf() {
		LocalContainerEntityManagerFactoryBean emf = new
				LocalContainerEntityManagerFactoryBean();
		//new org.springframework.orm.jpa.LocalEntityManagerFactoryBean()
		
		emf.setDataSource(webDataSource());
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setPackagesToScan("ru.specialist.dao");

		return emf;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(emf().getObject());
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	
	@Bean
	public CacheManager cacheManager() {
		/*SimpleCacheManager c = new SimpleCacheManager();
		List<Cache> caches = new ArrayList<Cache>();
		caches.add(new ConcurrentMapCache("courses"));
		c.setCaches(caches);
		return c;*/
		return new ConcurrentMapCacheManager("courses");
	}

}
