package taskadmin.faces.mbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import taskadmin.model.Course;

@ManagedBean
@RequestScoped
public class ManageCoursesBean {

	@ManagedProperty(value="#{param.code}")
	private String code = null;
	
	private Course course = new Course();
	
	

	public List<Course> findAll(){
		return Course.findAll();
	}
	

	public String saveCourse(){
		course.save();
		return "success";
	}
	
	public String remove(){
		Course.removeByCode(code);
		return "remove-success";
	}
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
	
}
