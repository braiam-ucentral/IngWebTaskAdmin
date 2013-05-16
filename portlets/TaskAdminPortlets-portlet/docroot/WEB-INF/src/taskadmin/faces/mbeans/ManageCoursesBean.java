package taskadmin.faces.mbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import taskadmin.model.Course;
import taskadmin.model.Teacher;

@ManagedBean
@RequestScoped
public class ManageCoursesBean {
	
	@ManagedProperty(value="#{param.code}")
	private String code = null;
	
	private String mode = "new";
	private String teacherId;
	
	private Course course = new Course();
	
	
	
	public ManageCoursesBean() {
		String code = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("code");
		if(code!=null){
			course = Course.findByCode(code);
			mode = "edit";
		}
	}

	public List<Course> findAll(){
		return Course.findAll();
	}
	

	public String saveCourse(){
		course.setTeacher(Teacher.findById(teacherId));
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


	public String getMode() {
		return mode;
	}


	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	
	
	
}
