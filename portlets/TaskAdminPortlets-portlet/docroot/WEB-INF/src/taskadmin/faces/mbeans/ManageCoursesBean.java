package taskadmin.faces.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import taskadmin.dto.CourseDTO;
import taskadmin.model.Course;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@RequestScoped
public class ManageCoursesBean {
	
	@ManagedProperty(value="#{param.code}")
	private String code = null;
	
	private String mode = "new";
	
	private Course course = new Course();
	
	public ManageCoursesBean() {
		String code = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("code");
		System.out.println("ManageCoursesBean cnnstuct. code="+code);
		if(code!=null){
			course = Course.findByCode(code);
			mode = "edit";
		}
	}
	

	public List<CourseDTO> findAll() throws PortalException, SystemException{
		System.out.println("ManageCoursesBean.findAll");
		List<Course> courseList = Course.findAll();
		List<CourseDTO> courseDTOList = new ArrayList<CourseDTO>();
		
		for(Course course : courseList){
			courseDTOList.add(CourseDTO.from(course));
		}
		return courseDTOList;
	}
	
	
	public List<CourseDTO> findByCurrentTeacher() throws PortalException, SystemException{
		System.out.println("ManageCoursesBean.findByCurrentTeacher");
		return CourseDTO.from(Course.findByCurrentTeacher());
	}

	public String saveCourse(){
		System.out.println("ManageCoursesBean.saveCourse");
		course.save();
		return "success";
	}
	
	public String remove(){
		System.out.println("ManageCoursesBean.remove");
		Course.removeByCode(code);
		return "remove-success";
	}
	

	public String getCode() {
		System.out.println("ManageCoursesBean.getCode");
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Course getCourse() {
		System.out.println("ManageCoursesBean.getCourse");
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}


	public String getMode() {
		System.out.println("ManageCoursesBean.getMode");
		return mode;
	}


	public void setMode(String mode) {
		this.mode = mode;
	}

	
	
}
