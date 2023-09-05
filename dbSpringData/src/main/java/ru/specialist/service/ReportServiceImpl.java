package ru.specialist.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.specialist.dao.CourseRepository;

@Service("reports")
public class ReportServiceImpl implements ReportService {
	@Autowired
	private CourseRepository courseDao;
	
	// O(n^2)
	double mediana(int... m) {
		Arrays.sort(m);
		if (m.length % 2 == 1)
			return m[m.length / 2];
		else
			return (m[m.length / 2] + m[m.length / 2-1]) / 2.0;
	} 
	
	@Override
	public double getMedianaCourseLength() {
		int[] m = courseDao.findAll().stream()
					.mapToInt(c->c.getLength()).toArray();
		return mediana(m);
	}

}
