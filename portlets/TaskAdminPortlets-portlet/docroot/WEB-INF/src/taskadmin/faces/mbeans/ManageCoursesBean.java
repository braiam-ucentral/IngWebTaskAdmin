package taskadmin.faces.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import taskadmin.dto.CourseDTO;
import taskadmin.model.Course;

@ManagedBean
@RequestScoped
public class ManageCoursesBean {
	
	@ManagedProperty(value="#{param.code}")
	private String code = null;
	
	private String mode = "new";
	
	private Course course = new Course();
	
	
	
	public ManageCoursesBean() {
		String code = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("code");
		if(code!=null){
			course = Course.findByCode(code);
			mode = "edit";
		}
	}

	public List<CourseDTO> findAll() throws PortalException, SystemException{
		List<Course> courseList = Course.findAll();
		List<CourseDTO> courseDTOList = new ArrayList<CourseDTO>();
		
		for(Course course : courseList){
			courseDTOList.add(CourseDTO.from(course));
		}
		return courseDTOList;
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


	public String getMode() {
		return mode;
	}


	public void setMode(String mode) {
		this.mode = mode;
	}

	
	
}
