package ru.specialist.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CourseRowMapper implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course c = new Course();
		c.setId( rs.getInt("id") );
		c.setTitle( rs.getString("title") );
		c.setLength( rs.getInt("length") );
		c.setDescription( rs.getString("description") );
		return c;
	}
}
