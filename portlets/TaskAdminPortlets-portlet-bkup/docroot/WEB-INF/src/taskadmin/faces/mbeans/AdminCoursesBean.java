package taskadmin.faces.mbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import taskadmin.model.Course;

@ManagedBean
public class AdminCoursesBean {
	
	public List<Course> findAllCourses(){
		List<Course> courseList = new ArrayList<Course>();
		

		courseList.add(new Course("First course", "AAA001", 60, new Date(), new Date()));
		courseList.add(new Course("Applied Math", "MTH789", 42, new Date(), new Date()));
		courseList.add(new Course("Contemporary thought", "THO015", 13, new Date(), new Date()));
		courseList.add(new Course("Software development", "SWD000", 25, new Date(), new Date()));
		
		return courseList;
	}
	
	
}
