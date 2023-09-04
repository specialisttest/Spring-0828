package ru.specialist.dbJDBC;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import ru.specialist.dao.CourseDAO;
import ru.specialist.dao.JdbcCourseDAO;

@Configuration
@PropertySource("jdbc.properties")
@ComponentScan("ru.specialist.dao")
public class DaoConfig {
	
	//@Value("${jdbc.url}")
	//private String url;
	
	@Autowired
	private Environment env;
	
	//@Bean(destroyMethod = "close") // no need for close() or shutdown()
	@Bean
	public DataSource webDataSource() {
		BasicDataSource ds = new BasicDataSource();
		//ds.setUrl((url);
		ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate( webDataSource() );
	}
	
	@Bean
	public CourseDAO courseDAO() {
		JdbcCourseDAO dao = new JdbcCourseDAO();
		dao.setJdbcTemplate(jdbcTemplate());
		return dao;
	}

}
