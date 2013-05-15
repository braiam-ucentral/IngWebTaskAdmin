package taskadmin.faces.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import taskadmin.model.Course;

@ManagedBean
@RequestScoped
public class CreateCourseBean {

	private Course course = new Course();
	
	public String saveCourse(){
		course.save();
		return "success";
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
}
